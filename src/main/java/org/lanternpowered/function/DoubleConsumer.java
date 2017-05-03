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

import java.util.function.Consumer;

@FunctionalInterface
public interface DoubleConsumer extends Consumer<Double>, java.util.function.DoubleConsumer {

    /**
     * Converts the given {@link Consumer&lt;Double&gt;} into
     * a {@link DoubleConsumer}.
     *
     * @param consumer The consumer
     * @return The double consumer
     */
    static DoubleConsumer of(Consumer<? super Double> consumer) {
        return consumer instanceof DoubleConsumer ? (DoubleConsumer) consumer : consumer::accept;
    }

    /**
     * Converts the given {@link java.util.function.DoubleConsumer} into
     * a {@link DoubleConsumer}.
     *
     * @param consumer The consumer
     * @return The double consumer
     */
    static DoubleConsumer of(java.util.function.DoubleConsumer consumer) {
        return consumer instanceof DoubleConsumer ? (DoubleConsumer) consumer : consumer::accept;
    }

    /**
     * Performs this operation on the given double value.
     *
     * @param value The input value
     */
    @Override
    default void accept(Double value) {
        accept(value.doubleValue());
    }

    /**
     * @see Consumer#andThen(Consumer)
     */
    default DoubleConsumer andThen(DoubleConsumer after) {
        requireNonNull(after, "after");
        return value -> { accept(value); after.accept(value); };
    }

    /**
     * @see Consumer#andThen(Consumer)
     */
    @Override
    default DoubleConsumer andThen(Consumer<? super Double> after) {
        requireNonNull(after, "after");
        if (after instanceof DoubleConsumer) {
            return andThen((DoubleConsumer) after);
        }
        return value -> { accept(value); after.accept(value); };
    }

    /**
     * @see java.util.function.DoubleConsumer#andThen(java.util.function.DoubleConsumer)
     */
    @Override
    default DoubleConsumer andThen(java.util.function.DoubleConsumer after) {
        requireNonNull(after, "after");
        if (after instanceof DoubleConsumer) {
            return andThen((DoubleConsumer) after);
        }
        return value -> { accept(value); after.accept(value); };
    }
}
