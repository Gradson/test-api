package org.api.test.number2;

public class NumberTwo {

    public int[] sort(int[] data) {
        int aux = 0;

        for(int i = 0; i<5; i++){
            for(int j = 0; j<4; j++){
                if(data[j] > data[j + 1]){
                    aux = data[j];
                    data[j] = data[j+1];
                    data[j+1] = aux;
                }
            }
        }

        return data;
    }
}
