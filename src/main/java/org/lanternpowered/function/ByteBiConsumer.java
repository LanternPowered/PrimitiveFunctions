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
public interface ByteBiConsumer extends BiConsumer<Byte, Byte> {

    /**
     * Converts the given {@link BiConsumer&lt;Byte, Byte&gt;} into
     * a {@link ByteBiConsumer}.
     *
     * @param consumer The consumer
     * @return The byte bi consumer
     */
    static ByteBiConsumer of(BiConsumer<Byte, Byte> consumer) {
        requireNonNull(consumer, "consumer");
        return consumer instanceof ByteBiConsumer ? (ByteBiConsumer) consumer : consumer::accept;
    }

    /**
     * Performs this operation on the given byte values.
     *
     * @param a The first input value
     * @param b The second input value
     */
    void accept(byte a, byte b);

    /**
     * Performs this operation on the given byte values.
     *
     * @param a The first input value
     * @param b The second input value
     */
    @Override
    default void accept(Byte a, Byte b) {
        accept(a.byteValue(), b.byteValue());
    }

    /**
     * @see BiConsumer#andThen(BiConsumer)
     */
    default ByteBiConsumer andThen(ByteBiConsumer after) {
        requireNonNull(after, "after");
        return (a, b) -> { accept(a, b); after.accept(a, b); };
    }

    /**
     * @see BiConsumer#andThen(BiConsumer)
     */
    @Override
    default ByteBiConsumer andThen(BiConsumer<? super Byte, ? super Byte> after) {
        requireNonNull(after, "after");
        if (after instanceof ByteBiConsumer) {
            return andThen((ByteBiConsumer) after);
        }
        return (a, b) -> { accept(a, b); after.accept(a, b); };
    }
}
