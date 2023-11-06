package br.com.rocha.restaapitoaws.mapper.custom;

import br.com.rocha.restaapitoaws.data.vo.v2.PersonVOV2;
import br.com.rocha.restaapitoaws.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonVOV2 convertEntityToVo(Person person){//Recebe uma Entidade e devolve VO
        PersonVOV2 vo = new PersonVOV2();
        vo.setId(person.getId());
        vo.setAddress(person.getAddress());
        vo.setBirthDay(new Date());
        vo.setLastName(person.getLastName());
        vo.setGender(person.getGender());
        return vo;
    }

    public Person convertVoToEntity(PersonVOV2 person){//Converter VO para Entidades
        Person entity = new Person();
        entity.setId(person.getId());
        entity.setAddress(person.getAddress());
        ///vo.setBirthDay(new Date());
        entity.setLastName(person.getLastName());
        entity.setGender(person.getGender());
        return entity;
    }
}
