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

import java.util.function.Function;
import java.util.function.Supplier;

@FunctionalInterface
public interface LongSupplier extends Supplier<Long>, java.util.function.LongSupplier {

    /**
     * Converts the given {@link Supplier&lt;Long&gt;} into
     * a {@link LongSupplier}.
     *
     * @param supplier The supplier
     * @return The long supplier
     */
    static LongSupplier of(Supplier<Long> supplier) {
        requireNonNull(supplier, "supplier");
        return supplier instanceof LongSupplier ? (LongSupplier) supplier : supplier::get;
    }

    /**
     * Converts the given {@link java.util.function.LongSupplier} into
     * a {@link LongSupplier}.
     *
     * @param supplier The supplier
     * @return The long supplier
     */
    static LongSupplier of(java.util.function.LongSupplier supplier) {
        requireNonNull(supplier, "supplier");
        return supplier instanceof LongSupplier ? (LongSupplier) supplier : supplier::getAsLong;
    }

    /**
     * Gets a long result.
     *
     * @return A result
     */
    @Override
    default Long get() {
        return getAsLong();
    }

    /**
     * Converts this {@link LongSupplier} into a {@link ByteSupplier}
     * that casts the long to a byte value.
     *
     * @return The byte supplier
     */
    default ByteSupplier toByte() {
        return () -> (byte) getAsLong();
    }

    /**
     * Converts this {@link LongSupplier} into a {@link CharSupplier}
     * that casts the long to a char value.
     *
     * @return The char supplier
     */
    default CharSupplier toChar() {
        return () -> (char) getAsLong();
    }

    /**
     * Converts this {@link LongSupplier} into a {@link DoubleSupplier}
     * that casts the long to a double value.
     *
     * @return The double supplier
     */
    default DoubleSupplier toDouble() {
        return () -> (double) getAsLong();
    }

    /**
     * Converts this {@link LongSupplier} into a {@link FloatSupplier}
     * that casts the long to a float value.
     *
     * @return The float supplier
     */
    default FloatSupplier toFloat() {
        return () -> (float) getAsLong();
    }

    /**
     * Converts this {@link LongSupplier} into a {@link IntSupplier}
     * that casts the long to a int value.
     *
     * @return The int supplier
     */
    default IntSupplier toInt() {
        return () -> (int) getAsLong();
    }

    /**
     * Converts this {@link LongSupplier} into a {@link ShortSupplier}
     * that casts the long to a short value.
     *
     * @return The short supplier
     */
    default ShortSupplier toShort() {
        return () -> (short) getAsLong();
    }

    /**
     * Maps this {@link LongSupplier} to a {@link Supplier} with
     * the given result type {@link T}.
     *
     * @param function The function to map the values
     * @param <T> The result value type
     * @return The supplier
     */
    default <T> Supplier<T> map(Function<Long, T> function) {
        requireNonNull(function, "function");
        if (function instanceof LongToObjectFunction) {
            return map((LongToObjectFunction<T>) function);
        }
        return () -> function.apply(getAsLong());
    }

    /**
     * Maps this {@link LongSupplier} to a {@link Supplier} with
     * the given result type {@link T}.
     *
     * @param function The function to map the values
     * @param <T> The result value type
     * @return The supplier
     */
    default <T> Supplier<T> map(LongToObjectFunction<T> function) {
        requireNonNull(function, "function");
        return () -> function.apply(getAsLong());
    }

    /**
     * Maps this {@link LongSupplier} to a {@link BooleanSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default BooleanSupplier mapToBoolean(Function<Long, Boolean> function) {
        requireNonNull(function, "function");
        if (function instanceof LongToBooleanFunction) {
            return mapToBoolean((LongToBooleanFunction) function);
        }
        return () -> function.apply(getAsLong());
    }

    /**
     * Maps this {@link LongSupplier} to a {@link BooleanSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default BooleanSupplier mapToBoolean(LongToBooleanFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsBoolean(getAsLong());
    }

    /**
     * Maps this {@link LongSupplier} to a {@link ByteSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default ByteSupplier mapToByte(Function<Long, Byte> function) {
        requireNonNull(function, "function");
        if (function instanceof LongToByteFunction) {
            return mapToByte((LongToByteFunction) function);
        }
        return () -> function.apply(getAsLong());
    }

    /**
     * Maps this {@link LongSupplier} to a {@link ByteSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default ByteSupplier mapToByte(LongToByteFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsByte(getAsLong());
    }

    /**
     * Maps this {@link LongSupplier} to a {@link CharSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default CharSupplier mapToChar(Function<Long, Character> function) {
        requireNonNull(function, "function");
        if (function instanceof LongToCharFunction) {
            return mapToChar((LongToCharFunction) function);
        }
        return () -> function.apply(getAsLong());
    }

    /**
     * Maps this {@link LongSupplier} to a {@link CharSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default CharSupplier mapToChar(LongToCharFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsChar(getAsLong());
    }

    /**
     * Maps this {@link LongSupplier} to a {@link LongSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default DoubleSupplier mapToDouble(Function<Long, Double> function) {
        requireNonNull(function, "function");
        if (function instanceof LongToDoubleFunction) {
            return mapToDouble((LongToDoubleFunction) function);
        }
        return () -> function.apply(getAsLong());
    }

    /**
     * Maps this {@link LongSupplier} to a {@link LongSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default DoubleSupplier mapToDouble(LongToDoubleFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsDouble(getAsLong());
    }

    /**
     * Maps this {@link LongSupplier} to a {@link FloatSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default FloatSupplier mapToFloat(Function<Long, Float> function) {
        requireNonNull(function, "function");
        if (function instanceof LongToFloatFunction) {
            return mapToFloat((LongToFloatFunction) function);
        }
        return () -> function.apply(getAsLong());
    }

    /**
     * Maps this {@link LongSupplier} to a {@link FloatSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default FloatSupplier mapToFloat(LongToFloatFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsFloat(getAsLong());
    }

    /**
     * Maps this {@link LongSupplier} to a {@link LongSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default IntSupplier mapToInt(Function<Long, Integer> function) {
        requireNonNull(function, "function");
        if (function instanceof LongToIntFunction) {
            return mapToInt((LongToIntFunction) function);
        }
        return () -> function.apply(getAsLong());
    }

    /**
     * Maps this {@link LongSupplier} to a {@link IntSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default IntSupplier mapToInt(LongToIntFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsInt(getAsLong());
    }

    /**
     * Maps this {@link LongSupplier} to a {@link IntSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default IntSupplier mapToInt(java.util.function.LongToIntFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsInt(getAsLong());
    }

    /**
     * Maps this {@link LongSupplier} to a {@link LongSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default LongSupplier mapToLong(Function<Long, Long> function) {
        requireNonNull(function, "function");
        if (function instanceof LongToLongFunction) {
            return mapToLong((LongToLongFunction) function);
        }
        return () -> function.apply(getAsLong());
    }

    /**
     * Maps this {@link LongSupplier} to a {@link LongSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default LongSupplier mapToLong(LongToLongFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsLong(getAsLong());
    }

    /**
     * Maps this {@link LongSupplier} to a {@link ShortSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default ShortSupplier mapToShort(Function<Long, Short> function) {
        requireNonNull(function, "function");
        if (function instanceof LongToShortFunction) {
            return mapToShort((LongToShortFunction) function);
        }
        return () -> function.apply(getAsLong());
    }

    /**
     * Maps this {@link LongSupplier} to a {@link ShortSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default ShortSupplier mapToShort(LongToShortFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsShort(getAsLong());
    }
}
