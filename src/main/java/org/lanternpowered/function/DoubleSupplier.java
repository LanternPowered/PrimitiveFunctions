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
public interface DoubleSupplier extends Supplier<Double>, java.util.function.DoubleSupplier {

    /**
     * Converts the given {@link Supplier&lt;Double&gt;} into
     * a {@link DoubleSupplier}.
     *
     * @param supplier The supplier
     * @return The byte supplier
     */
    static DoubleSupplier of(Supplier<Double> supplier) {
        return supplier instanceof DoubleSupplier ? (DoubleSupplier) supplier : supplier::get;
    }

    /**
     * Converts the given {@link java.util.function.DoubleSupplier} into
     * a {@link DoubleSupplier}.
     *
     * @param supplier The supplier
     * @return The byte supplier
     */
    static DoubleSupplier of(java.util.function.DoubleSupplier supplier) {
        return supplier instanceof DoubleSupplier ? (DoubleSupplier) supplier : supplier::getAsDouble;
    }

    /**
     * Gets a double result.
     *
     * @return A result
     */
    @Override
    default Double get() {
        return getAsDouble();
    }

    /**
     * Converts this {@link DoubleSupplier} into a {@link ByteSupplier}
     * that casts the double to a byte value.
     *
     * @return The byte supplier
     */
    default ByteSupplier toByte() {
        return () -> (byte) getAsDouble();
    }

    /**
     * Converts this {@link DoubleSupplier} into a {@link CharSupplier}
     * that casts the double to a char value.
     *
     * @return The char supplier
     */
    default CharSupplier toChar() {
        return () -> (char) getAsDouble();
    }

    /**
     * Converts this {@link DoubleSupplier} into a {@link FloatSupplier}
     * that casts the double to a float value.
     *
     * @return The float supplier
     */
    default FloatSupplier toFloat() {
        return () -> (float) getAsDouble();
    }

    /**
     * Converts this {@link DoubleSupplier} into a {@link IntSupplier}
     * that casts the double to a int value.
     *
     * @return The int supplier
     */
    default IntSupplier toInt() {
        return () -> (int) getAsDouble();
    }

    /**
     * Converts this {@link DoubleSupplier} into a {@link LongSupplier}
     * that casts the double to a long value.
     *
     * @return The long supplier
     */
    default LongSupplier toLong() {
        return () -> (long) getAsDouble();
    }

    /**
     * Converts this {@link DoubleSupplier} into a {@link ShortSupplier}
     * that casts the double to a short value.
     *
     * @return The short supplier
     */
    default ShortSupplier toShort() {
        return () -> (short) getAsDouble();
    }

    /**
     * Maps this {@link DoubleSupplier} to a {@link Supplier} with
     * the given result type {@link T}.
     *
     * @param function The function to map the values
     * @param <T> The result value type
     * @return The supplier
     */
    default <T> Supplier<T> map(Function<Double, T> function) {
        requireNonNull(function, "function");
        if (function instanceof DoubleToObjectFunction) {
            return map((DoubleToObjectFunction<T>) function);
        }
        return () -> function.apply(getAsDouble());
    }

    /**
     * Maps this {@link DoubleSupplier} to a {@link Supplier} with
     * the given result type {@link T}.
     *
     * @param function The function to map the values
     * @param <T> The result value type
     * @return The supplier
     */
    default <T> Supplier<T> map(DoubleToObjectFunction<T> function) {
        requireNonNull(function, "function");
        return () -> function.apply(getAsDouble());
    }

    /**
     * Maps this {@link DoubleSupplier} to a {@link BooleanSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default BooleanSupplier mapToBoolean(Function<Double, Boolean> function) {
        requireNonNull(function, "function");
        if (function instanceof DoubleToBooleanFunction) {
            return mapToBoolean((DoubleToBooleanFunction) function);
        }
        return () -> function.apply(getAsDouble());
    }

    /**
     * Maps this {@link DoubleSupplier} to a {@link BooleanSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default BooleanSupplier mapToBoolean(DoubleToBooleanFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsBoolean(getAsDouble());
    }

    /**
     * Maps this {@link DoubleSupplier} to a {@link ByteSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default ByteSupplier mapToByte(Function<Double, Byte> function) {
        requireNonNull(function, "function");
        if (function instanceof DoubleToByteFunction) {
            return mapToByte((DoubleToByteFunction) function);
        }
        return () -> function.apply(getAsDouble());
    }

    /**
     * Maps this {@link DoubleSupplier} to a {@link ByteSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default ByteSupplier mapToByte(DoubleToByteFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsByte(getAsDouble());
    }

    /**
     * Maps this {@link DoubleSupplier} to a {@link CharSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default CharSupplier mapToChar(Function<Double, Character> function) {
        requireNonNull(function, "function");
        if (function instanceof DoubleToCharFunction) {
            return mapToChar((DoubleToCharFunction) function);
        }
        return () -> function.apply(getAsDouble());
    }

    /**
     * Maps this {@link DoubleSupplier} to a {@link CharSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default CharSupplier mapToChar(DoubleToCharFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsChar(getAsDouble());
    }

    /**
     * Maps this {@link DoubleSupplier} to a {@link DoubleSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default DoubleSupplier mapToDouble(Function<Double, Double> function) {
        requireNonNull(function, "function");
        if (function instanceof DoubleToDoubleFunction) {
            return mapToDouble((DoubleToDoubleFunction) function);
        }
        return () -> function.apply(getAsDouble());
    }

    /**
     * Maps this {@link DoubleSupplier} to a {@link DoubleSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default DoubleSupplier mapToDouble(DoubleToDoubleFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsDouble(getAsDouble());
    }

    /**
     * Maps this {@link DoubleSupplier} to a {@link FloatSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default FloatSupplier mapToFloat(Function<Double, Float> function) {
        requireNonNull(function, "function");
        if (function instanceof DoubleToFloatFunction) {
            return mapToFloat((DoubleToFloatFunction) function);
        }
        return () -> function.apply(getAsDouble());
    }

    /**
     * Maps this {@link DoubleSupplier} to a {@link FloatSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default FloatSupplier mapToFloat(DoubleToFloatFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsFloat(getAsDouble());
    }

    /**
     * Maps this {@link DoubleSupplier} to a {@link IntSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default IntSupplier mapToInt(Function<Double, Integer> function) {
        requireNonNull(function, "function");
        if (function instanceof DoubleToIntFunction) {
            return mapToInt((DoubleToIntFunction) function);
        }
        return () -> function.apply(getAsDouble());
    }

    /**
     * Maps this {@link DoubleSupplier} to a {@link IntSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default IntSupplier mapToInt(java.util.function.DoubleToIntFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsInt(getAsDouble());
    }

    /**
     * Maps this {@link DoubleSupplier} to a {@link IntSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default IntSupplier mapToInt(DoubleToIntFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsInt(getAsDouble());
    }

    /**
     * Maps this {@link DoubleSupplier} to a {@link LongSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default LongSupplier mapToLong(Function<Double, Long> function) {
        requireNonNull(function, "function");
        if (function instanceof DoubleToLongFunction) {
            return mapToLong((DoubleToLongFunction) function);
        }
        return () -> function.apply(getAsDouble());
    }

    /**
     * Maps this {@link DoubleSupplier} to a {@link LongSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default LongSupplier mapToLong(java.util.function.DoubleToLongFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsLong(getAsDouble());
    }

    /**
     * Maps this {@link DoubleSupplier} to a {@link LongSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default LongSupplier mapToLong(DoubleToLongFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsLong(getAsDouble());
    }

    /**
     * Maps this {@link DoubleSupplier} to a {@link ShortSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default ShortSupplier mapToShort(Function<Double, Short> function) {
        requireNonNull(function, "function");
        if (function instanceof DoubleToShortFunction) {
            return mapToShort((DoubleToShortFunction) function);
        }
        return () -> function.apply(getAsDouble());
    }

    /**
     * Maps this {@link DoubleSupplier} to a {@link ShortSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default ShortSupplier mapToShort(DoubleToShortFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsShort(getAsDouble());
    }
}
