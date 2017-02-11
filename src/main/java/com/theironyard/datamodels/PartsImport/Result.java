package com.theironyard.datamodels.PartsImport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.theironyard.datamodels.PartsImport.Part;

/**
 * Created by graceconnelly on 2/11/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {

        private int element_id;;
        private int quantity;
        private String set_num;
        private Part part;
        private Color color;

        public Result() {
        }

        public Result(int element_id, int quantity, String set_num, Part part, Color color) {
            this.element_id = element_id;
            this.quantity = quantity;
            this.set_num = set_num;
            this.part = part;
            this.color = color;
        }

        public int getElement_id() {
            return element_id;
        }

        public void setElement_id(int element_id) {
            this.element_id = element_id;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public String getSet_num() {
            return set_num;
        }

        public void setSet_num(String set_num) {
            this.set_num = set_num;
        }

        public Part getPart() {
            return part;
        }

        public void setPart(Part part) {
            this.part = part;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "element_id=" + element_id +
                    ", quantity=" + quantity +
                    ", set_num='" + set_num + '\'' +
                    ", part=" + part +
                    ", color=" + color +
                    '}';
        }
}
