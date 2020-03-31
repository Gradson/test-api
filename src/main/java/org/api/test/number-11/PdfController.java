package org.api.test.number11;

@RestController("files")
public class PdfController {

    private final PdfApplicationServices applicationServices;

    @PostMapping
    public String start() {
       final String hashProcess = applicationServices.start();
       return hashProcess;
    }

    @GetMapping(value = "/{hashProcess}")
    public String retrieveFile(@PathVariable final String hashProcess) {
        //Aqui poderia ser um enum ou até mesmo um obj
        final String status = applicationServices.retrieveStatus(hashProcess);
        return status;
    }

    //o método retrieveFile desta classe, poderia implementar hateoas, assim poderia já passar o link quando o arquivo
    //pronto estivesse e sempre retornar o status, independentemente do arquivo estar pronto.
}
