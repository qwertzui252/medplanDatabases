package medplandatabases

class Uawdb {
    static searchable = [only: ['pznConcat', 'pzn1', 'pzn2']]

    String pzn1
    String pzn2
    String pznConcat
    String wechselwirkung


    static constraints = {
        pzn1(blank: false)
        pzn2(blank: false)
        pznConcat(blank: false)
        wechselwirkung()
    }
}
