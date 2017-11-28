/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasitoko;

/**
 *
 * @author abdul
 */
public class ValidasiField {

    public static boolean hasValue(String field) {
        return field.length() != 0;
    }

    public static boolean isNumber(String field) {
        if (!hasValue(field)) {
            return false;
        } else {
            return field.chars().allMatch(Character::isDigit);
        }
    }
}
