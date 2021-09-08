package medplandatabases

class Medplandb {
    static searchable = [only: ['pZN', 'name']]

    String name
    String geburtsdatum

    String pZN
    String wirkstoff
    String handelsname
    String stärke
    String form

    String einheit
    String morgens
    String mittags
    String abends
    String zurNacht
    String einnahmehinweise
    String einnahmegrund


    static constraints = {
        name()
        geburtsdatum()

        pZN()
        wirkstoff()
        handelsname()
        stärke()
        form()

        einheit()
        morgens()
        mittags()
        abends()
        zurNacht()
        einnahmehinweise()
        einnahmegrund()
    }
}
