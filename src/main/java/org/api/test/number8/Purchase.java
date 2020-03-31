package org.api.test.number8;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Purchase {
    @Id
    Integer id;
    String label;
    double value;
}
