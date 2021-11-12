package br.pucpr.cwbshop.service;

import br.pucpr.cwbshop.domain.entity.Address;
import br.pucpr.cwbshop.domain.entity.City;
import br.pucpr.cwbshop.domain.entity.Country;
import br.pucpr.cwbshop.domain.entity.State;
import br.pucpr.cwbshop.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public Address save(Address address){
        City city = address.getCity();
        city.setAddress(address);

        State state = address.getState();
        state.setAddress(address);

        Country country = address.getCountry();
        country.setAddress(address);

        return addressRepository.save(address);
    }
}
