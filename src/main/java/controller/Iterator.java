/**
 * @packageName     : controller
 * @filewName       : Iterator.java
 * @author          : Junghan Park
 * @date            : 2021.05.17
 * @description     : Iterator 패턴 설계.
 * =======================================================
 *      DATE         AUTHOR          NOTE
 * -------------------------------------------------------
 * 2021.05.17       Junghan Park   최초 생성
 */
package controller;

public interface Iterator {
    boolean hasNext();
    Object next();
}
