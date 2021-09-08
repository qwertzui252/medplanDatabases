package medplandatabases

//import grails.rest.*
//@Resource(uri='/amdb')

class Amdb {
    static searchable = [only: ['pZN', 'handelsname']]

    /*
    static mapping = {
        id name: 'pZN'
    }
    */

    String pZN
    String wirkstoff
    String handelsname
    String stärke
    String form
    //String einheit
    //String einnahmehinweise


    static constraints = {
        pZN()
        wirkstoff()
        handelsname()
        stärke()
        form()
        //einheit()
        //einnahmehinweise()
    }
}