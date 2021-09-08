package medplandatabases

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class UawdbController {

    UawdbService uawdbService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond uawdbService.list(params), model:[uawdbCount: uawdbService.count()]
    }

    def show(Long id) {
        respond uawdbService.get(id)
    }

    // method to search per PZN1
    def searchByPzn(String pzn1) {
        def b = Uawdb.findByPzn1("$pzn1")
        respond b
    }

    // method to search per PZN1 AND PZN2
    //curl -i -X GET -H "Accept: application/json" localhost:8080/uawdb/searchByPzn1AndPzn2?pzn1=07234681&pzn2=01437555
    def searchByPzn1AndPzn2(String pzn1, String pzn2) {
        def b = Uawdb.findByPzn1AndPzn2("$pzn1", "$pzn2")
        //def b = Uawdb.findByPzn1AndPzn2("07234681", "01437555")
        respond b
    }

    //curl -i -X GET -H "Accept: application/json" localhost:8080/uawdb/searchByPznChain?chain=0143755507234681
    def searchByPznChain(params) {
        String chain="$params.chain"
        chainLength = chain.length()
        makeCombinations(chain)

        respond uAWList
        uAWList.clear()
    }

    List<Uawdb> uAWList = new ArrayList<>();
    int chainLength;

    private void makeCombinations(String chain) {

        String[] ret = new String[chainLength/8];

        int i=0;
        for (int start = 0; start < chainLength; start += 8) {
            ret[i]=chain.substring(start, Math.min(chainLength, start + 8));
            i++;
        }
        combination(ret,2) //bei häufgerem "Ziehen" for-Schleife bauen, welche combination(ret,i) aufruft
    }

    void combination(String[] elements, int K) {

        // get the length of the array
        // e.g. for {'A','B','C','D'} => N = 4
        int N = elements.length;

        if (K > N) {
            System.out.println("Invalid input, K > N");
            return;
        }

        // calculate the possible combinations
        c(N, K);

        // init combination index array

        int[] combination = new int[K];

        int r = 0; // index for combination array
        int i = 0; // index for elements array

        while (r >= 0) {

            // forward step if i < (N + (r-K))
            if (i <= (N + (r - K))) {
                combination[r] = i;

                // if combination array is full print and increment i;
                if (r == K - 1) {
                    print(combination, elements);
                    i++;
                } else {
                    // if combination is not full yet, select next element
                    i = combination[r] + 1;
                    r++;
                }

            }

            // backward step
            else {
                r--;
                if (r >= 0)
                    i = combination[r] + 1;

            }
        }
    }


    private static int c(int n, int r) {
        int nf = fact(n);
        int rf = fact(r);
        int nrf = fact(n - r);
        int npr = nf / nrf;
        int ncr = npr / rf;

        System.out.println("C(" + n + "," + r + ") = " + ncr);

        return ncr;
    }

    private static int fact(int n) {
        if (n == 0)
            return 1;
        else
            return n * fact(n - 1);
    }

    private void print(int[] combination, String[] elements) {

        String output="";
        for (int z = 0; z < combination.length; z++) {

            output += elements[combination[z]];
            System.out.println("Outp "+output);
        }
        String[] lol = new String[2];
        lol[0]="12345678";
        lol[1]="87654321";

        def b = Uawdb.findByPznConcat(output)
        if(b!=null) {
            uAWList.add(b)
        }

    }
    private void haha(String s) {
        System.out.println("SSSS "+s);

    }

    def create() {
        respond new Uawdb(params)
    }

    def save(Uawdb uawdb) {
        if (uawdb == null) {
            notFound()
            return
        }

        try {
            uawdbService.save(uawdb)
        } catch (ValidationException e) {
            respond uawdb.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'uawdb.label', default: 'Uawdb'), uawdb.id])
                redirect uawdb
            }
            '*' { respond uawdb, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond uawdbService.get(id)
    }

    def update(Uawdb uawdb) {
        if (uawdb == null) {
            notFound()
            return
        }

        try {
            uawdbService.save(uawdb)
        } catch (ValidationException e) {
            respond uawdb.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'uawdb.label', default: 'Uawdb'), uawdb.id])
                redirect uawdb
            }
            '*'{ respond uawdb, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        uawdbService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'uawdb.label', default: 'Uawdb'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'uawdb.label', default: 'Uawdb'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
