/* NomNom created on 4/26/2020 inside the package - CTDL.Homework_6 */

package CTDL.Homework_6;

public class User implements Comparable<Object> {
    public int id;
    public String name;

    public User(UserBuilder userBuilder) {
        this.id = userBuilder.id;
        this.name = userBuilder.name;
    }

    @Override
    public int compareTo(Object o) {
        User user = (User) o;
        if (this.id != user.id) {
            if (this.id > user.id) return -1;
            else return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static class UserBuilder {
        private final int id;
        private String name;

        public UserBuilder(int id) {
            this.id = id;
        }

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}



