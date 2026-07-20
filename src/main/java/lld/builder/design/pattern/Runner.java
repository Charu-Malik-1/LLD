package lld.builder.design.pattern;

public class Runner {

    public static void main(String[] args) {
        //chaining
        User u= new User.Builder().fisrtName("charu").age(25).lastName("malik").build();
        Travel t=new Travel.Builder().travelInsurance(true).travelName("public").origin("delhi")
                .build();
    }
}
