package com.study.dp.creational.builder;

public class Phone {

    private String frontPanel;
    private String backPanel;
    private String processor;
    private String camera;

    public static class PhoneBuilder {
        private String frontPanel;
        private String backPanel;
        private String processor;
        private String camera;

        public PhoneBuilder(String frontPanel, String backPanel, String processor, String camera) {
            this.frontPanel = frontPanel;
            this.backPanel = backPanel;
            this.processor = processor;
            this.camera = camera;
        }

        public PhoneBuilder() {
        }

        public PhoneBuilder frontPanel(String frontPanel) {
            this.frontPanel = frontPanel;
            return this;
        }

        public PhoneBuilder backPanel(String backPanel) {
            this.backPanel = backPanel;
            return this;
        }

        public PhoneBuilder processor(String processor) {
            this.processor = processor;
            return this;
        }

        public PhoneBuilder camera(String camera) {
            this.camera = camera;
            return this;
        }

        public PhoneBuilder build() {
            return new PhoneBuilder(frontPanel, backPanel, processor, camera);
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("PhoneBuilder{");
            sb.append("frontPanel='").append(frontPanel).append('\'');
            sb.append(", backPanel='").append(backPanel).append('\'');
            sb.append(", processor='").append(processor).append('\'');
            sb.append(", camera='").append(camera).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
}

class Demo {
    public static void main(String[] args) {
        Phone.PhoneBuilder builder = new Phone.PhoneBuilder();
        builder.frontPanel("Silver").backPanel("Black").processor("android").camera("10MP").build();

        System.out.println(builder);

        Phone.PhoneBuilder builder2 = new Phone.PhoneBuilder();
        builder2.backPanel("Black").camera("10MP").build();
        System.out.println(builder2);
    }
}
