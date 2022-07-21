package cn.com.yusys.yusp.cm.indexplan.domain;

public class DataListDto {

        private String sort;
        private String targetValue;
        private String initialValue;
        public void setSort(String sort) {
            this.sort = sort;
        }
        public String getSort() {
            return sort;
        }

        public void setTargetValue(String targetValue) {
            this.targetValue = targetValue;
        }
        public String getTargetValue() {
            return targetValue;
        }

        public void setInitialValue(String initialValue) {
            this.initialValue = initialValue;
        }
        public String getInitialValue() {
            return initialValue;
        }
}
