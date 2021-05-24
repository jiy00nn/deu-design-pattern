/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

public interface Subject {
    public void registerObserver(Observer o); //주체에 옵저버들을 연결하기 위한 메서드
    public void removeObserver(Observer o); //주체에 연결된 옵저버들을 제거하기 위한 메서드
    public void notifyObservers(); // 주체의 데이터가 변경 될 경우 옵저버들에게 데이터의 업데이트 상태를 전달하기 위한 메서드
}