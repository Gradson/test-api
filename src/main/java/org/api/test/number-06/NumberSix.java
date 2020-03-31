package org.api.test.number6;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NumberSix {

    /*Com a utilização do parallelStream, que vai tentar dividir
    o processamento pelos processadores da máquina, contanto que uma operação
    não seja chamada, para ser sequencial
            (por exemplo, usando o forEachOrdered {nesse caso o processamento ainda seria sequencial]).
    */

        public <T> List<T> convertList(List list, Function function) {
        if(list != null && list.size() > 0) {
            return Collections.EMPTY_LIST;
        }

        return (List<T>) list.parallelStream().map(function).collect(Collectors.toList());
    }

}
