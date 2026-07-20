package lld.builder.design.pattern;

import lombok.Getter;

import java.util.Date;
import java.util.List;

public class Travel {
    private String travelName;
    private Date startDate;
    private Date endDate;
    private String origin;
    private String destination;
    private List<String> segments;
    private List<String> tags;
    private boolean travelInsurance;

    private Travel(Builder builder) {
        travelName = builder.getTravelName();
        startDate = builder.getStartDate();
        endDate = builder.getEndDate();
        origin = builder.getOrigin();
        destination = builder.getDestination();
        segments = builder.getSegments();
        tags = builder.getTags();
//       travelInsurance= builder.getTr
    }

    @Getter
    public static class Builder {
        private String travelName;
        private Date startDate;
        private Date endDate;
        private String origin;
        private String destination;
        private List<String> segments;
        private List<String> tags;
        private boolean travelInsurance;

        public Builder travelName(String t) {
            if (t == null)
                throw new IllegalStateException(" travel name cannot be null");
            this.travelName = t;
            return this;
        }

        public Builder startDate(Date t) {
            if (t == null)
                throw new IllegalStateException("start date cannot be null");
            this.startDate = t;
            return this;
        }

        public Builder endDate(Date t) {
            if (t == null)
                throw new IllegalStateException("end date cannot be null");
            this.endDate = t;
            return this;
        }

        public Builder origin(String t) {
            if (t == null)
                throw new IllegalStateException(" origin cannot be null");
            this.origin = t;
            return this;
        }

        public Builder segments(List<String> t) {
            if (t == null)
                throw new IllegalStateException("segments cannot be null");
            this.segments = t;
            return this;
        }

        public Builder travelInsurance(boolean t) {
            if (t == false)
                throw new IllegalStateException("travelInsurance cannot be null");
            this.travelInsurance = t;
            return this;
        }

        public Travel build() {
            return new Travel(this);
        }
    }


}
