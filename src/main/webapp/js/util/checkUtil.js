
/**
 * 电话号码校验
 * @returns {Boolean}
 */
function checkPhone(phone){ 
    if(!(/^1(3|4|5|7|8|9)\d{9}$/.test(phone))){ 
        return false; 
    } 
}