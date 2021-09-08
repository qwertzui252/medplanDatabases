package medplandatabases

class Userdb {

    String username
    String password
    String name
    String geburtsdatum

    static constraints = {
        username blank:false, nullable:false, size:5..15, matches:/[\S]+/, unique:true
        password blank:false, nullable:false, size:5..15, matches:/[\S]+/
        }
}