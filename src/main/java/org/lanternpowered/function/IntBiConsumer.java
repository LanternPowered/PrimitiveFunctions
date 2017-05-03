/*
 * This file is part of PrimitiveFunctions, licensed under the MIT License (MIT).
 *
 * Copyright (c) LanternPowered <https://github.com/LanternPowered>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the Software), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, andor sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED AS IS, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.lanternpowered.function;

import static java.util.Objects.requireNonNull;

import java.util.function.BiConsumer;

@FunctionalInterface
public interface IntBiConsumer extends BiConsumer<Integer, Integer> {

    /**
     * Converts the given {@link BiConsumer&lt;Integer, Integer&gt;} into
     * a {@link IntBiConsumer}.
     *
     * @param consumer The consumer
     * @return The int bi consumer
     */
    static IntBiConsumer of(BiConsumer<Integer, Integer> consumer) {
        requireNonNull(consumer, "consumer");
        return consumer instanceof IntBiConsumer ? (IntBiConsumer) consumer : consumer::accept;
    }

    /**
     * Performs this operation on the given int values.
     *
     * @param a The first input value
     * @param b The second input value
     */
    void accept(int a, int b);

    /**
     * Performs this operation on the given int values.
     *
     * @param a The first input value
     * @param b The second input value
     */
    @Override
    default void accept(Integer a, Integer b) {
        accept(a.intValue(), b.intValue());
    }

    /**
     * @see BiConsumer#andThen(BiConsumer)
     */
    default IntBiConsumer andThen(IntBiConsumer after) {
        requireNonNull(after, "after");
        return (a, b) -> { accept(a, b); after.accept(a, b); };
    }

    /**
     * @see BiConsumer#andThen(BiConsumer)
     */
    @Override
    default IntBiConsumer andThen(BiConsumer<? super Integer, ? super Integer> after) {
        requireNonNull(after, "after");
        if (after instanceof IntBiConsumer) {
            return andThen((IntBiConsumer) after);
        }
        return (a, b) -> { accept(a, b); after.accept(a, b); };
    }
}
