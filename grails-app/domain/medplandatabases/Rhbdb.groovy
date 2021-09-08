package medplandatabases

class Rhbdb {
    static searchable = [only: 'pZN']

    String pZN
    String beschreibung

    static constraints = {
        pZN()
        beschreibung()
    }
}