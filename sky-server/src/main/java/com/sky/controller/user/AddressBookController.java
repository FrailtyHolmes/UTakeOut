package com.sky.controller.user;

import com.sky.context.BaseContext;
import com.sky.entity.AddressBook;
import com.sky.result.Result;
import com.sky.service.AddressBookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Frailty
 * @date 2024年03月31日 20:55
 */

@RestController
@RequestMapping("/user/addressBook")
@Api(tags = "C端地址簿接口")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    /*
     * @Description: 查询当前登录用户的所有地址信息
     * @author Frailty
     * @date 2024/3/31 20:58
     * @return com.sky.result.Result<List<AddressBook>>
     */
    @GetMapping("/list")
    @ApiOperation("查询当前登录用户的所有地址信息")
    public Result<List<AddressBook>> list() {
        AddressBook addressBook = new AddressBook();
        addressBook.setUserId(BaseContext.getCurrentId());
        List<AddressBook> list = addressBookService.list(addressBook);
        return Result.success(list);
    }

    /*
     * @Description: 新增地址
     * @author Frailty
     * @date 2024/3/31 21:06
     * @param addressBook
     * @return com.sky.result.Result
     */
    @PostMapping
    @ApiOperation("新增地址")
    public Result save(@RequestBody AddressBook addressBook) {
        addressBookService.save(addressBook);
        return Result.success();
    }

    /*
     * @Description: 根据id查询地址
     * @author Frailty
     * @date 2024/3/31 21:10
     * @param id
     * @return com.sky.result.Result<com.sky.entity.AddressBook>
     */
    @GetMapping("/{id}")
    @ApiOperation("根据id查询地址")
    public Result<AddressBook> getById(@PathVariable Long id) {
        AddressBook addressBook = addressBookService.getById(id);
        return Result.success(addressBook);
    }

    /*
     * @Description: 根据id修改地址
     * @author Frailty
     * @date 2024/3/31 21:12
     * @param addressBook
     * @return com.sky.result.Result
     */
    @PutMapping
    @ApiOperation("根据id修改地址")
    public Result update(@RequestBody AddressBook addressBook) {
        addressBookService.update(addressBook);
        return Result.success();
    }

    /*
     * @Description: 设置默认地址
     * @author Frailty
     * @date 2024/3/31 21:19
     * @param addressBook
     * @return com.sky.result.Result
     */
    @PutMapping("/default")
    @ApiOperation("设置默认地址")
    public Result setDefault(@RequestBody AddressBook addressBook) {
        addressBookService.setDefault(addressBook);
        return Result.success();
    }

    /*
     * @Description: 根据id删除地址
     * @author Frailty
     * @date 2024/3/31 21:23
     * @param id
     * @return com.sky.result.Result
     */
    @DeleteMapping
    @ApiOperation("根据id删除地址")
    public Result deleteById(Long id) {
        addressBookService.deleteById(id);
        return Result.success();
    }

    @GetMapping("default")
    @ApiOperation("查询默认地址")
    public Result<AddressBook> getDefault() {
        //SQL:select * from address_book where user_id = ? and is_default = 1
        AddressBook addressBook = new AddressBook();
        addressBook.setIsDefault(1);
        addressBook.setUserId(BaseContext.getCurrentId());
        List<AddressBook> list = addressBookService.list(addressBook);
        //每个用户id最多只有一个默认地址
        if (list != null && list.size() == 1) {
            return Result.success(list.get(0));
        }
        
        return Result.error("没有查询到默认地址");
    }
}
