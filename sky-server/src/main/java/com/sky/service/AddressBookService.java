package com.sky.service;

import com.sky.entity.AddressBook;

import java.util.List;

/**
 * @author Frailty
 * @date 2024年03月31日 20:57
 */
public interface AddressBookService {
    /*
     * @Description: 查询当前登录用户的所有地址信息
     * @author Frailty
     * @date 2024/3/31 21:01
     * @param addressBook 
     * @return java.util.List<com.sky.entity.AddressBook>
     */
    List<AddressBook> list(AddressBook addressBook);

    /*
     * @Description: 新增地址
     * @author Frailty
     * @date 2024/3/31 21:06
     * @param addressBook 
     */
    void save(AddressBook addressBook);

    /*
     * @Description: 根据id查询地址
     * @author Frailty
     * @date 2024/3/31 21:10
     * @param id 
     * @return com.sky.entity.AddressBook
     */
    AddressBook getById(Long id);

    /*
     * @Description: 根据id修改地址
     * @author Frailty
     * @date 2024/3/31 21:13
     * @param addressBook 
     */
    void update(AddressBook addressBook);

    /*
     * @Description: 设置默认地址
     * @author Frailty
     * @date 2024/3/31 21:19
     * @param addressBook 
     */
    void setDefault(AddressBook addressBook);

    /*
     * @Description: 根据id删除地址
     * @author Frailty
     * @date 2024/3/31 21:24
     * @param id 
     */
    void deleteById(Long id);
}
