package org.api.test.number5;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class A {
    int id;
    String label;
    LocalDate day;
    short offset;

    public Stream<A> withGaps(Collection<A> source, LocalDate begin, LocalDate end){
        Stream<A> stream = filterAndSorted(source, begin, end);
        return stream.collect(Collectors.groupingBy(A::getDay)).values()
                .stream().flatMap(i ->create(i));
    }

    private Stream<A> create(List<A> list) {
        LocalDate day = list.get(0).getDay();
        for(short i=0; i<1440; i++) {
            short finalI = i;
            A a1 = list.stream().filter(a -> a.getOffset() == finalI).findFirst().orElse(createSynthetic(day, i));

            if(a1.getId() < 0) {
                list.add(a1);
            }
        }

        return list.stream().sorted(Comparator.comparing(A::getOffset));
    }


    private Stream<A> filterAndSorted(Collection<A> source, LocalDate begin, LocalDate end) {
        return source.stream()
                .filter(item -> (!begin.isAfter(day) && day.isBefore(end)))
                .sorted(getComparator(source));
    }

    private A createSynthetic(final LocalDate day, final short offset) {
        return A.builder().id(-1).label("FAKE").day(day).offset(offset).build();
    }

    private Comparator<? super A> getComparator(Collection<A> source) {
        return Comparator.comparing(A::getDay)
                .thenComparing(Comparator.nullsLast(Comparator.comparing(A::getOffset)));
    }
}