package com.example.foodmenus;

import java.util.List;

public class Food {

    /**
     * menuId : 1
     * menuName : Quisque velit nisi, pretium ut lacinia in, elementum id enim.
     * imageUrl : https://theculturetrip.com/wp-content/uploads/2020/04/2bcpa1n.jpg
     * material : [{"1":"Vivamus magna justo, lacinia eget consectetur sed, convallis at tellus.","2":"Curabitur arcu erat, accumsan id imperdiet et, porttitor at sem.","3":"Sed porttitor lectus nibh.","4":"Vivamus suscipit tortor eget felis porttitor volutpat.","5":"Nulla quis lorem ut libero malesuada feugiat."}]
     * process : [{"1":"Donec rutrum congue leo eget malesuada.","2":"Proin eget tortor risus.","3":"ullamcorper sit amet ligula.","4":"Curabitur non nulla sit amet nisl tempus convallis quis ac lectus."}]
     */

    private int menuId;
    private String menuName;
    private String imageUrl;
    private List<Material> material;
    private List<Process> process;

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Material> getMaterial() {
        return material;
    }

    public void setMaterial(List<Material> material) {
        this.material = material;
    }

    public List<Process> getProcess() {
        return process;
    }

    public void setProcess(List<Process> process) {
        this.process = process;
    }

    public static class Material {
         int keys;
         String values;

        public int getKeys() {
            return keys;
        }

        public void setKeys(int keys) {
            this.keys = keys;
        }

        public String getValues() {
            return values;
        }

        public void setValues(String values) {
            this.values = values;
        }
    }

    public static class Process {

        int keys;
        String values;

        public int getKeys() {
            return keys;
        }

        public void setKeys(int keys) {
            this.keys = keys;
        }

        public String getValues() {
            return values;
        }

        public void setValues(String values) {
            this.values = values;
        }
    }
}
