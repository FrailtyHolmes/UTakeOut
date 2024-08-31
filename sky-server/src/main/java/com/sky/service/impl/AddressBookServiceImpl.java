package com.sky.service.impl;

import com.sky.context.BaseContext;
import com.sky.entity.AddressBook;
import com.sky.mapper.AddressBookMapper;
import com.sky.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Frailty
 * @date 2024年03月31日 20:57
 */
@Service
public class AddressBookServiceImpl implements AddressBookService {
    @Autowired
    private AddressBookMapper addressBookMapper;
    
    /*
     * @Description: 查询当前登录用户的所有地址信息
     * @author Frailty
     * @date 2024/3/31 21:01
     * @param addressBook 
     * @return java.util.List<com.sky.entity.AddressBook>
     */
    @Override
    public List<AddressBook> list(AddressBook addressBook) {
        return addressBookMapper.list(addressBook);
    }

    /*
     * @Description: 新增地址
     * @author Frailty
     * @date 2024/3/31 21:06
     * @param addressBook 
     */
    @Override
    public void save(AddressBook addressBook) {
        addressBook.setUserId(BaseContext.getCurrentId());
        addressBook.setIsDefault(0);
        addressBookMapper.insert(addressBook);
    }

    /*
     * @Description: 根据id查询地址
     * @author Frailty
     * @date 2024/3/31 21:10
     * @param id 
     * @return com.sky.entity.AddressBook
     */
    @Override
    public AddressBook getById(Long id) {
        AddressBook addressBook = addressBookMapper.getById(id);
        return addressBook;
    }

    /*
     * @Description: 根据id修改地址
     * @author Frailty
     * @date 2024/3/31 21:13
     * @param addressBook 
     */
    @Override
    public void update(AddressBook addressBook) {
        addressBookMapper.update(addressBook);
    }

    /*
     * @Description: 设置默认地址
     * @author Frailty
     * @date 2024/3/31 21:19
     * @param addressBook 
     */
    @Override
    @Transactional
    public void setDefault(AddressBook addressBook) {
        //1、将当前用户的所有地址修改为非默认地址 
        // update address_book set is_default = ? where user_id = ?
        addressBook.setIsDefault(0);
        addressBook.setUserId(BaseContext.getCurrentId());
        addressBookMapper.updateIsDefaultByUserId(addressBook);

        //2、将当前地址改为默认地址 update address_book set is_default = ? where id = ?
        addressBook.setIsDefault(1);
        addressBookMapper.update(addressBook);
    }

    /*
     * @Description: 根据id删除地址
     * @author Frailty
     * @date 2024/3/31 21:24
     * @param id 
     */
    @Override
    public void deleteById(Long id) {
        addressBookMapper.deleteById(id);
    }
}
