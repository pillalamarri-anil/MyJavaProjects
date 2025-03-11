package DesignPatterns.Builder;

public class Student {

    private String name;
    private int age;
    private String address;
    private String school;
    private String grade;
    private String teacher;
    private String parent;

    private Student(Builder builder)
    {
        this.name = builder.name;
        this.age = builder.age;
        this.address = builder.address;
        this.school = builder.school;
        this.grade = builder.grade;
        this.teacher = builder.teacher;
        this.parent = builder.parent;
    }

    static Builder getBuilder()
    {
        return new Builder();
    }

    @Override
    public String toString()
    {
        return "Name: " + name + ", Age: " + age + ", Address: " + address + ", School: " + school + ", Grade: " + grade + ", Teacher: " + teacher + ", Parent: " + parent;
    }

    public static class Builder {

        private String name;
        private int age;
        private String address;
        private String school;
        private String grade;
        private String teacher;
        private String parent;

        private Builder() // make constructor private, so that it can only be called from Student class
        {
        }
    
        public Builder setName(String name)
        {
            this.name = name;
            return this;
        }
    
        public Builder setAge(int age)
        {
            this.age = age;
            return this;
        }
    
        public Builder setAddress(String address)
        {
            this.address = address;
            return this;
        }
    
        public Builder setSchool(String school)
        {
            this.school = school;
            return this;
        }
    
        public Builder setGrade(String grade)
        {
            this.grade = grade;
            return this;
        }
    
        public Builder setTeacher(String teacher)
        {
            this.teacher = teacher;
            return this;
        }
    
        public Builder setParent(String parent)
        {
            this.parent = parent;
            return this;
        }
    
        public Student build()
        {
            if(name == null || name.isEmpty())
            {
                throw new IllegalArgumentException("Name is required");
            }
            if(age <= 0 || age > 100)
            {
                throw new IllegalArgumentException("Age is required");
            }

            return new Student(this);
        }
    
    }
}
