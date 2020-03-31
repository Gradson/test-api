package org.api.test.number8;

import java.util.Set;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class User {
    @Id
    Integer id;@OneToMany
    Set<Purchase> purchases;
    @Version
    Integer version;
}

