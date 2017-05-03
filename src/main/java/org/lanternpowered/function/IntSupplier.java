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
public interface IntSupplier extends Supplier<Integer>, java.util.function.IntSupplier {

    /**
     * Converts the given {@link Supplier&lt;Integer&gt;} into
     * a {@link IntSupplier}.
     *
     * @param supplier The supplier
     * @return The int supplier
     */
    static IntSupplier of(Supplier<Integer> supplier) {
        requireNonNull(supplier, "supplier");
        return supplier instanceof IntSupplier ? (IntSupplier) supplier : supplier::get;
    }

    /**
     * Converts the given {@link java.util.function.IntSupplier} into
     * a {@link IntSupplier}.
     *
     * @param supplier The supplier
     * @return The int supplier
     */
    static IntSupplier of(java.util.function.IntSupplier supplier) {
        requireNonNull(supplier, "supplier");
        return supplier instanceof IntSupplier ? (IntSupplier) supplier : supplier::getAsInt;
    }

    /**
     * Gets a integer result.
     *
     * @return A result
     */
    @Override
    default Integer get() {
        return getAsInt();
    }

    /**
     * Converts this {@link IntSupplier} into a {@link ByteSupplier}
     * that casts the int to a byte value.
     *
     * @return The byte supplier
     */
    default ByteSupplier toByte() {
        return () -> (byte) getAsInt();
    }

    /**
     * Converts this {@link IntSupplier} into a {@link CharSupplier}
     * that casts the int to a char value.
     *
     * @return The char supplier
     */
    default CharSupplier toChar() {
        return () -> (char) getAsInt();
    }

    /**
     * Converts this {@link IntSupplier} into a {@link DoubleSupplier}
     * that casts the int to a double value.
     *
     * @return The double supplier
     */
    default DoubleSupplier toDouble() {
        return () -> (double) getAsInt();
    }

    /**
     * Converts this {@link IntSupplier} into a {@link FloatSupplier}
     * that casts the int to a float value.
     *
     * @return The float supplier
     */
    default FloatSupplier toFloat() {
        return () -> (float) getAsInt();
    }

    /**
     * Converts this {@link IntSupplier} into a {@link LongSupplier}
     * that casts the int to a long value.
     *
     * @return The long supplier
     */
    default LongSupplier toLong() {
        return () -> (long) getAsInt();
    }

    /**
     * Converts this {@link IntSupplier} into a {@link ShortSupplier}
     * that casts the int to a short value.
     *
     * @return The short supplier
     */
    default ShortSupplier toShort() {
        return () -> (short) getAsInt();
    }

    /**
     * Maps this {@link IntSupplier} to a {@link Supplier} with
     * the given result type {@link T}.
     *
     * @param function The function to map the values
     * @param <T> The result value type
     * @return The supplier
     */
    default <T> Supplier<T> map(Function<Integer, T> function) {
        requireNonNull(function, "function");
        if (function instanceof IntToObjectFunction) {
            return map((IntToObjectFunction<T>) function);
        }
        return () -> function.apply(getAsInt());
    }

    /**
     * Maps this {@link IntSupplier} to a {@link Supplier} with
     * the given result type {@link T}.
     *
     * @param function The function to map the values
     * @param <T> The result value type
     * @return The supplier
     */
    default <T> Supplier<T> map(IntToObjectFunction<T> function) {
        requireNonNull(function, "function");
        return () -> function.apply(getAsInt());
    }

    /**
     * Maps this {@link IntSupplier} to a {@link BooleanSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default BooleanSupplier mapToBoolean(Function<Integer, Boolean> function) {
        requireNonNull(function, "function");
        if (function instanceof IntToBooleanFunction) {
            return mapToBoolean((IntToBooleanFunction) function);
        }
        return () -> function.apply(getAsInt());
    }

    /**
     * Maps this {@link IntSupplier} to a {@link BooleanSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default BooleanSupplier mapToBoolean(IntToBooleanFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsBoolean(getAsInt());
    }

    /**
     * Maps this {@link IntSupplier} to a {@link ByteSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default ByteSupplier mapToByte(Function<Integer, Byte> function) {
        requireNonNull(function, "function");
        if (function instanceof IntToByteFunction) {
            return mapToByte((IntToByteFunction) function);
        }
        return () -> function.apply(getAsInt());
    }

    /**
     * Maps this {@link IntSupplier} to a {@link ByteSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default ByteSupplier mapToByte(IntToByteFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsByte(getAsInt());
    }

    /**
     * Maps this {@link IntSupplier} to a {@link CharSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default CharSupplier mapToChar(Function<Integer, Character> function) {
        requireNonNull(function, "function");
        if (function instanceof IntToCharFunction) {
            return mapToChar((IntToCharFunction) function);
        }
        return () -> function.apply(getAsInt());
    }

    /**
     * Maps this {@link IntSupplier} to a {@link CharSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default CharSupplier mapToChar(IntToCharFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsChar(getAsInt());
    }

    /**
     * Maps this {@link IntSupplier} to a {@link IntSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default DoubleSupplier mapToDouble(Function<Integer, Double> function) {
        requireNonNull(function, "function");
        if (function instanceof IntToDoubleFunction) {
            return mapToDouble((IntToDoubleFunction) function);
        }
        return () -> function.apply(getAsInt());
    }

    /**
     * Maps this {@link IntSupplier} to a {@link IntSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default DoubleSupplier mapToDouble(IntToDoubleFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsDouble(getAsInt());
    }

    /**
     * Maps this {@link IntSupplier} to a {@link FloatSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default FloatSupplier mapToFloat(Function<Integer, Float> function) {
        requireNonNull(function, "function");
        if (function instanceof IntToFloatFunction) {
            return mapToFloat((IntToFloatFunction) function);
        }
        return () -> function.apply(getAsInt());
    }

    /**
     * Maps this {@link IntSupplier} to a {@link FloatSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default FloatSupplier mapToFloat(IntToFloatFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsFloat(getAsInt());
    }

    /**
     * Maps this {@link IntSupplier} to a {@link IntSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default IntSupplier mapToInt(Function<Integer, Integer> function) {
        requireNonNull(function, "function");
        if (function instanceof IntToIntFunction) {
            return mapToInt((IntToIntFunction) function);
        }
        return () -> function.apply(getAsInt());
    }

    /**
     * Maps this {@link IntSupplier} to a {@link IntSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default IntSupplier mapToInt(IntToIntFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsInt(getAsInt());
    }

    /**
     * Maps this {@link IntSupplier} to a {@link LongSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default LongSupplier mapToLong(Function<Integer, Long> function) {
        requireNonNull(function, "function");
        if (function instanceof IntToLongFunction) {
            return mapToLong((IntToLongFunction) function);
        }
        return () -> function.apply(getAsInt());
    }

    /**
     * Maps this {@link IntSupplier} to a {@link LongSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default LongSupplier mapToLong(java.util.function.IntToLongFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsLong(getAsInt());
    }

    /**
     * Maps this {@link IntSupplier} to a {@link LongSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default LongSupplier mapToLong(IntToLongFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsLong(getAsInt());
    }

    /**
     * Maps this {@link IntSupplier} to a {@link ShortSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default ShortSupplier mapToShort(Function<Integer, Short> function) {
        requireNonNull(function, "function");
        if (function instanceof IntToShortFunction) {
            return mapToShort((IntToShortFunction) function);
        }
        return () -> function.apply(getAsInt());
    }

    /**
     * Maps this {@link IntSupplier} to a {@link ShortSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default ShortSupplier mapToShort(IntToShortFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsShort(getAsInt());
    }
}
