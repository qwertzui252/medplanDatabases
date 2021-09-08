package medplandatabases

class BootStrap {

    def init = { servletContext ->

        new Userdb(username:"chapy", password:"chapy", name:"Chapy the First", geburtsdatum: "11.11.1911").save()
        new Userdb(username:"ddapy", password:"ddapy", name:"Ddapy the Second", geburtsdatum: "12.12.1912").save()
        new Userdb(username:"eeapy", password:"eeapy", name:"Eeapy the Third", geburtsdatum: "01.01.2000").save()
        new Userdb(username:"ffapy", password:"ffapy", name:"Ffapy the First", geburtsdatum: "04.04.2012").save()

        new Rhbdb(pZN: "07234681", beschreibung: "Nach neuesten Erkenntnissen führt die längere Einnahme von der Arznei zur vollständigen Erblindung.").save()
        new Rhbdb(pZN: "06320266", beschreibung: "Nach neuesten Erkenntnissen führt die längere Einnahme von der Arznei zur vollständigen Ermüdung.").save()

        new Uawdb(pzn1:"07234681", pzn2:"01437555", pznConcat:"0143755507234681", wechselwirkung:"Blutung").save()
        new Uawdb(pzn1:"06320266", pzn2:"07746607", pznConcat:"0632026607746607", wechselwirkung:"ungewollte Schwangerschaft durch Abschwächung der Anti-Baby-Pille").save()

        new Amdb(pZN:"07234681", wirkstoff:"Rizinusöl", handelsname:"ABTEI Abführkapseln SN Kapseln", stärke:"500 mg", form:"Kapseln", einheit:"einh", einnahmehinweise:"test").save()
        new Amdb(pZN:"01437555", wirkstoff:"Lanitop", handelsname:"LANITOP 0,1 mg Tabletten", stärke:"0,1 mg", form:"Tabletten", einheit:"einh", einnahmehinweise:"test").save()
        new Amdb(pZN: "15893535", wirkstoff: "Ibuprofen", handelsname: "IBUPROFEN RedCare 400 mg Filmtabletten", stärke: "400mg", form: "Filmen", einheit: "fgfgfg", einnahmehinweise: "sdsdsd").save()
        new Amdb(pZN:"15893535", wirkstoff:"Ibuprofen", handelsname:"IBUPROFEN RedCare 400 mg Filmtabletten", stärke:"400 mg", form:"Filmtabletten", einheit:"einh", einnahmehinweise:"test").save()
        new Amdb(pZN:"06953066", wirkstoff:"Levothyroxin", handelsname:"LEVOTHYROXIN-Natrium Pulver", stärke:"", form:"Pulver", einheit:"einh", einnahmehinweise:"test").save()
        new Amdb(pZN:"05046863", wirkstoff:"Pantoprazol", handelsname:"PANTOPRAZOL-1A Pharma 20 mg magensaftres.Tabletten", stärke:"20 mg", form:"Tabletten, magensaftgeschützte", einheit:"einh", einnahmehinweise:"test").save()
        new Amdb(pZN:"09436058", wirkstoff:"Metamizol", handelsname:"METAMIZOL AbZ 500 mg Tabletten", stärke:"443,08 mg", form:"Tabletten", einheit:"einh", einnahmehinweise:"test").save()
        new Amdb(pZN:"01755663", wirkstoff:"Ramipril", handelsname:"RAMIPRIL AbZ 10 mg Tabletten", stärke:"10 mg", form:"Tabletten", einheit:"einh", einnahmehinweise:"test").save()
        new Amdb(pZN:"03820548", wirkstoff:"Bisoprolol", handelsname:"BISOPROLOL 10-1A Pharma Filmtabletten", stärke:"8,49 mg", form:"Filmtabletten", einheit:"einh", einnahmehinweise:"test").save()
        new Amdb(pZN:"00889947", wirkstoff:"Amlodipin", handelsname:"AMLODIPIN-1A Pharma 10 mg Tabletten N", stärke:"10 mg", form:"Tabletten", einheit:"einh", einnahmehinweise:"test").save()
        new Amdb(pZN:"03540731", wirkstoff:"Diclofenac", handelsname:"DICLOFENAC 100 retard Heumann Tabletten", stärke:"93,09 mg", form:"Retard-Tabletten", einheit:"einh", einnahmehinweise:"test").save()
        new Amdb(pZN:"05008058", wirkstoff:"Torasemid", handelsname:"TORASEMID-1A Pharma 100 mg Tabletten", stärke:"100 mg", form:"Tabletten", einheit:"einh", einnahmehinweise:"test").save()
        new Amdb(pZN:"02950970", wirkstoff:"Metformin", handelsname:"METFORMIN 1.000-1A Pharma Filmtabletten", stärke:"779,86 mg", form:"Filmtabletten", einheit:"einh", einnahmehinweise:"test").save()
        new Amdb(pZN:"04778587", wirkstoff:"Omeprazol", handelsname:"OMEPRAZOL-1A Pharma 40 mg magensaftres.Hartkapseln", stärke:"40 mg", form:"magensaftres.Hartkapseln", einheit:"einh", einnahmehinweise:"test").save()
        new Amdb(pZN:"07402204", wirkstoff:"Acetylsalicylsäure", handelsname:"ASS 100 HEXAL Tabletten", stärke:"100 mg", form:"Tabletten", einheit:"einh", einnahmehinweise:"test").save()
        new Amdb(pZN:"14184038", wirkstoff:"Salbutamol", handelsname:"SALBUTAMOL AL Fertiginhalat Ampullen Lsg.f.Verneb.", stärke:"1,25 mg", form:"Inhalationsampullen", einheit:"einh", einnahmehinweise:"test").save()
        new Amdb(pZN:"03419171", wirkstoff:"Prednisolon", handelsname:"PREDNISOLON 250 mg Rotexmedica Injektionssusp.", stärke:"250 mg", form:"Injektionssuspension", einheit:"einh", einnahmehinweise:"test").save()
        new Amdb(pZN:"00106388", wirkstoff:"Allopurinol", handelsname:"ALLOPURINOL STADA 300 mg Tabletten", stärke:"300 mg", form:"Tabletten", einheit:"einh", einnahmehinweise:"test").save()
        new Amdb(pZN:"13816447", wirkstoff:"Xylometazolin", handelsname:"MEDICON Xylometazolin 0,1% Nasenspray", stärke:"0,87 mg", form:"Nasenspray", einheit:"einh", einnahmehinweise:"test").save()
        new Amdb(pZN:"04751588", wirkstoff:"Amoxicillin", handelsname:"AMOXICILLIN AL TS Pulver z.Herstell.e.Susp.z.Einn.", stärke:"300 mg", form:"Tabletten", einheit:"einh", einnahmehinweise:"test").save()
        new Amdb(pZN:"04245922", wirkstoff:"Insulin", handelsname:"ACTRAPID Penfill 100 I.E./ml Inj.-Lsg.i.Patrone", stärke:"3 ml", form:"Zylinderampullen", einheit:"einh", einnahmehinweise:"test").save()
        new Amdb(pZN:"01017095", wirkstoff:"Tilidin", handelsname:"TILIDIN AbZ Tropfen 50 mg/4 mg pro 0,72 ml", stärke:"69,44 mg", form:"Tropfen", einheit:"einh", einnahmehinweise:"test").save()
        new Amdb(pZN:"00178229", wirkstoff:"Cefuroxim", handelsname:"CEFUROXIM 250 mg-1A Pharma überzogene Tabletten", stärke:"250 mg", form:"Überzogene Tabletten", einheit:"einh", einnahmehinweise:"test").save()
        new Amdb(pZN:"10274388", wirkstoff:"CIPROFLOXACIN", handelsname:"CIPROFLOXACIN 2 mg/ml Inf.-Lsg.200 mg/100 ml", stärke:"200 mg", form:"Infusionslösung", einheit:"einh", einnahmehinweise:"test").save()
        new Amdb(pZN:"00451145", wirkstoff:"Acetylcystein", handelsname:"ACC 200 TABS", stärke:"200 mg", form:"Tabletten", einheit:"einh", einnahmehinweise:"test").save()
        new Amdb(pZN:"15570022", wirkstoff:"Solifenacin succinat", handelsname:"BELMACINA 5MG FTA", stärke:"10 mg", form:"Filmtabletten", einheit:"einh", einnahmehinweise:"test").save()
        new Amdb(pZN:"01623683", wirkstoff:"Bisoprolol fumarat", handelsname:"BISOPROLOL PLUS 10/25 1A", stärke:"10 mg", form:"Filmtabletten", einheit:"einh", einnahmehinweise:"test").save()
        new Amdb(pZN:"05485031", wirkstoff:"Ibandronsäure natrium-1-Wasser", handelsname:"BONVIVA 150MG", stärke:"168,79 mg", form:"Filmtabletten", einheit:"einh", einnahmehinweise:"test").save()
        new Amdb(pZN:"09482785", wirkstoff:"Candesartan cilexetil", handelsname:"CANDESARTAN BASICS 4MG", stärke:"4 mg", form:"Tabletten", einheit:"einh", einnahmehinweise:"test").save()
        new Amdb(pZN:"13835054", wirkstoff:"Ondansetron hydrochlorid-2-Wasser", handelsname:"CELLONDAN 4MG FILMTABL", stärke:"5 mg", form:"Filmtabletten", einheit:"einh", einnahmehinweise:"test").save()
        new Amdb(pZN:"15861736", wirkstoff:"Enoxaparin natrium", handelsname:"CRUSIA 4.000 IE 40MG/0.4ML", stärke:"4000 I.E.", form:"Injektionslösung in einer Fertigspritze", einheit:"einh", einnahmehinweise:"test").save()
        new Amdb(pZN:"07633932", wirkstoff:"Dexamethasondihydrogenphosphat-Dinatrium", handelsname:"DEXA RATIO 100 MG INJ LSG", stärke:"109,31 mg", form:"Ampullen", einheit:"einh", einnahmehinweise:"test").save()
        new Amdb(pZN:"01434120", wirkstoff:"Felodipin", handelsname:"FELODIPIN STADA 10MG RET", stärke:"10 mg", form:"Retard-Tabletten", einheit:"einh", einnahmehinweise:"test").save()
        new Amdb(pZN:"11486158", wirkstoff:"Fentanyl", handelsname:"ALUID Pharma GmbH", stärke:"2,75 mg", form:"Pflaster transdermal", einheit:"einh", einnahmehinweise:"test").save()
        new Amdb(pZN:"08701995", wirkstoff:"Flunarizin dihydrochlorid", handelsname:"FLUNAVERT 5MG", stärke:"5,9 mg", form:"Hartkapseln", einheit:"einh", einnahmehinweise:"test").save()
        new Amdb(pZN:"14170875", wirkstoff:"Hydromorphon hydrochlorid", handelsname:"HYDROMORPHON 1A 8MG", stärke:"4 mg", form:"Retard-Kapseln", einheit:"einh", einnahmehinweise:"test").save()
        new Amdb(pZN:"4192456", wirkstoff:"Lamotrigin", handelsname:"LAMOTRIGIN AL 100MG TABL", stärke:"100 mg", form:"Tabletten", einheit:"einh", einnahmehinweise:"test").save()

        new Medplandb(name: "test", geburtsdatum: "01.01.1999", pZN: "1234567", wirkstoff: "wirkstoff", handelsname: "handelsname", stärke: "stärke", form: "form", einheit: "einheit", morgens: "1", mittags: "1", abends: "1", zurNacht: "1", einnahmehinweise: "einnahmehinweise", einnahmegrund: "einnahmegrund").save()

    }
    def destroy = {
    }
}
