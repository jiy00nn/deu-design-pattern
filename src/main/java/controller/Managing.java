/**
 * @packageName     : controller
 * @filewName       : Managing.java
 * @author          : Junghan Park
 * @date            : 2021.05.17
 * @description     : Strategy 패턴 설계.
 * =======================================================
 *      DATE         AUTHOR          NOTE
 * -------------------------------------------------------
 * 2021.05.17       Junghan Park   search() 매개변수 추가
 */
package controller;

/**
 *
 * @author wndgk
 */
public abstract class Managing {
    private String name;
    private SearchStrategy searchStrategy;
    private ManagementStrategy managementStrategy;
    
    public Managing(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void search(String id, String name){
        searchStrategy.search(id, name);
    }
    
    public void update(){
        managementStrategy.update();
    }
    
    public void modify(){
        managementStrategy.modify();
    }

    public void setSearchStrategy(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    public void setManagementStrategy(ManagementStrategy managementStrategy) {
        this.managementStrategy = managementStrategy;
    }
    
    
}
