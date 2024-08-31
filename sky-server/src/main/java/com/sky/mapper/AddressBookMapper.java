package com.sky.mapper;

import com.sky.entity.AddressBook;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface AddressBookMapper {
    /*
     * @Description: 查询当前登录用户的所有地址信息
     * @author Frailty
     * @date 2024/3/31 21:02
     * @param addressBook
     * @return java.util.List<com.sky.entity.AddressBook>
     */
    List<AddressBook> list(AddressBook addressBook);

    /*
     * @Description: 新增地址
     * @author Frailty
     * @date 2024/3/31 21:07
     * @param addressBook
     */
    @Insert("insert into address_book " +
            "(user_id, consignee, phone, sex, province_code, province_name, city_code, city_name, " +
            "district_code, district_name, detail, label,is_default) " +
            "VALUES " +
            "(#{userId}, #{consignee}, #{phone}, #{sex}, #{provinceCode}, #{provinceName}, #{cityCode}, #{cityName}," +
            "#{districtCode}, #{districtName}, #{detail}, #{label}, #{isDefault})")
    void insert(AddressBook addressBook);

    /*
     * @Description: 根据id查询地址
     * @author Frailty
     * @date 2024/3/31 21:11
     * @param id
     * @return com.sky.entity.AddressBook
     */
    @Select("select * from address_book where id = #{id}")
    AddressBook getById(Long id);

    /*
     * @Description: 根据id修改地址
     * @author Frailty
     * @date 2024/3/31 21:13
     * @param addressBook
     */
    void update(AddressBook addressBook);

    /*
     * @Description: 根据 用户id修改 是否默认地址
     * @author Frailty
     * @date 2024/3/31 21:22
     * @param addressBook
     */
    @Update("update address_book set is_default = #{isDefault} where user_id = #{userId}")
    void updateIsDefaultByUserId(AddressBook addressBook);

    /*
     * @Description: 根据id删除地址
     * @author Frailty
     * @date 2024/3/31 21:24
     * @param id 
     */
    @Delete("delete from address_book where id = #{id}")
    void deleteById(Long id);
    
}
