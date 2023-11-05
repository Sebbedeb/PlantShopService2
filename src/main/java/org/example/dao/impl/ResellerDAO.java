package org.example.dao.impl;

import org.example.config.Populate;
import org.example.dao.IResellerDAO;
import org.example.dto.PlantDTO;
import org.example.dto.ResellerDTO;
import org.example.exception.ApiException;
import java.util.List;
public class ResellerDAO implements IResellerDAO
{
    public static List<ResellerDTO> resellerDTOList;
    public static ResellerDAO instance;
    public ResellerDAO getInstance()
    {
        if(instance == null)
        {
            instance = new ResellerDAO();
            resellerDTOList = Populate.populateResellers();
        }
        return instance;
    }
    @Override
    public ResellerDTO read(Integer id) throws ApiException
    {
        ResellerDTO resellerDTO = resellerDTOList.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
        if(resellerDTO == null)
        {
            throw new ApiException(404, "Reseller not found");
        }
        return resellerDTO;
    }

    @Override
    public List<ResellerDTO> readAll()
    {
        return resellerDTOList;
    }

    @Override
    public ResellerDTO create(ResellerDTO resellerDTO) throws ApiException
    {
        resellerDTOList.add(resellerDTO);
        return resellerDTO;
    }

    @Override
    public ResellerDTO update(Integer integer, ResellerDTO resellerDTO) throws ApiException
    {
        ResellerDTO resellerDTO1 = read(integer);
        if(resellerDTO1 == null)
        {
            throw new ApiException(404, "Reseller not found");
        }
        resellerDTO1.setName(resellerDTO.getName());
        resellerDTO1.setAddress(resellerDTO.getAddress());
        resellerDTO1.setPhone(resellerDTO.getPhone());
        return resellerDTO1;
    }

    @Override
    public void delete(Integer integer) throws ApiException
    {
        ResellerDTO resellerDTO = read(integer);
        if(resellerDTO == null)
        {
            throw new ApiException(404, "Reseller not found");
        }
        resellerDTOList.remove(resellerDTO);
    }
}
