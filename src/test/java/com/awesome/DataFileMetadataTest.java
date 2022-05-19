package com.awesome;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;

class DataFileMetadataTest {

    @Test
    public void memoize(){
        AtomicInteger called = new AtomicInteger();

        Supplier<Integer> lazyCaching = Memoize.memoizeSupplier(()-> called.getAndIncrement());

        assertThat(lazyCaching.get()).isEqualTo(0);
        assertThat(called.get()).isEqualTo(1);
        assertThat(lazyCaching.get()).isEqualTo(0);
        assertThat(called.get()).isEqualTo(1);
    }
}
