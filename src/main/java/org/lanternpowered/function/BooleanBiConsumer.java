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
public interface BooleanBiConsumer extends BiConsumer<Boolean, Boolean> {

    /**
     * Converts the given {@link BiConsumer&lt;Boolean, Boolean&gt;} into
     * a {@link BooleanBiConsumer}.
     *
     * @param consumer The consumer
     * @return The boolean bi consumer
     */
    static BooleanBiConsumer of(BiConsumer<Boolean, Boolean> consumer) {
        requireNonNull(consumer, "consumer");
        return consumer instanceof BooleanBiConsumer ? (BooleanBiConsumer) consumer : consumer::accept;
    }

    /**
     * Performs this operation on the given boolean values.
     *
     * @param a The first input value
     * @param b The second input value
     */
    void accept(boolean a, boolean b);

    /**
     * Performs this operation on the given boolean values.
     *
     * @param a The first input value
     * @param b The second input value
     */
    @Override
    default void accept(Boolean a, Boolean b) {
        accept(a.booleanValue(), b.booleanValue());
    }

    /**
     * @see BiConsumer#andThen(BiConsumer)
     */
    default BooleanBiConsumer andThen(BooleanBiConsumer after) {
        requireNonNull(after, "after");
        return (a, b) -> { accept(a, b); after.accept(a, b); };
    }

    /**
     * @see BiConsumer#andThen(BiConsumer)
     */
    @Override
    default BooleanBiConsumer andThen(BiConsumer<? super Boolean, ? super Boolean> after) {
        requireNonNull(after, "after");
        if (after instanceof BooleanBiConsumer) {
            return andThen((BooleanBiConsumer) after);
        }
        return (a, b) -> { accept(a, b); after.accept(a, b); };
    }
}
