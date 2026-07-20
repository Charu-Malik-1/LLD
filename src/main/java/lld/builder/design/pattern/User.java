package lld.builder.design.pattern;

import lombok.Getter;

public class User {
    private String fisrtName;
    private String lastName;
    private int age;
    private User(Builder builder) {
        this.fisrtName = builder.getFisrtName();
        this.lastName = builder.getLastName();
        this.age = builder.getAge();
    }
    @Getter
    static class Builder {
        private String fisrtName;
        private String lastName;
        private int age;
        public Builder() {}
        public User build(){
            return new User(this);
        }
        public Builder fisrtName(String fn) {
            if (fn == null)
                throw new IllegalArgumentException("First name cannot be null");
            this.fisrtName = fn;
            return this;
        }
        public Builder age(int x) {
            if (x < 0)
                throw new IllegalArgumentException("age cannot be null");
            this.age = x;
            return this;
        }
        public Builder lastName(String fn) {
            if (fn == null)
                throw new IllegalArgumentException("last name cannot be null");
            this.lastName = fn;
            return this;
        }


    }
}
