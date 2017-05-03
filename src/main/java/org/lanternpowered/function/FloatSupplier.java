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
public interface FloatSupplier extends Supplier<Float> {

    /**
     * Converts the given {@link Supplier&lt;Float&gt;} into
     * a {@link FloatSupplier}.
     *
     * @param supplier The supplier
     * @return The float supplier
     */
    static FloatSupplier of(Supplier<Float> supplier) {
        return supplier instanceof FloatSupplier ? (FloatSupplier) supplier : supplier::get;
    }

    /**
     * Gets a float result.
     *
     * @return A result
     */
    float getAsFloat();

    /**
     * Gets a float result.
     *
     * @return A result
     */
    @Override
    default Float get() {
        return getAsFloat();
    }

    /**
     * Converts this {@link FloatSupplier} into a {@link ByteSupplier}
     * that casts the float to a byte value.
     *
     * @return The byte supplier
     */
    default ByteSupplier toByte() {
        return () -> (byte) getAsFloat();
    }

    /**
     * Converts this {@link FloatSupplier} into a {@link CharSupplier}
     * that casts the float to a char value.
     *
     * @return The char supplier
     */
    default CharSupplier toChar() {
        return () -> (char) getAsFloat();
    }

    /**
     * Converts this {@link FloatSupplier} into a {@link DoubleSupplier}
     * that casts the float to a double value.
     *
     * @return The function
     */
    default DoubleSupplier toDouble() {
        return this::getAsFloat;
    }

    /**
     * Converts this {@link FloatSupplier} into a {@link IntSupplier}
     * that casts the float to a int value.
     *
     * @return The int supplier
     */
    default IntSupplier toInt() {
        return () -> (int) getAsFloat();
    }

    /**
     * Converts this {@link FloatSupplier} into a {@link LongSupplier}
     * that casts the float to a long value.
     *
     * @return The long supplier
     */
    default LongSupplier toLong() {
        return () -> (long) getAsFloat();
    }

    /**
     * Converts this {@link FloatSupplier} into a {@link ShortSupplier}
     * that casts the float to a short value.
     *
     * @return The short supplier
     */
    default ShortSupplier toShort() {
        return () -> (short) getAsFloat();
    }

    /**
     * Maps this {@link DoubleSupplier} to a {@link Supplier} with
     * the given result type {@link T}.
     *
     * @param function The function to map the values
     * @param <T> The result value type
     * @return The supplier
     */
    default <T> Supplier<T> map(Function<Float, T> function) {
        requireNonNull(function, "function");
        if (function instanceof FloatToObjectFunction) {
            return map((FloatToObjectFunction<T>) function);
        }
        return () -> function.apply(getAsFloat());
    }

    /**
     * Maps this {@link FloatSupplier} to a {@link Supplier} with
     * the given result type {@link T}.
     *
     * @param function The function to map the values
     * @param <T> The result value type
     * @return The supplier
     */
    default <T> Supplier<T> map(FloatToObjectFunction<T> function) {
        requireNonNull(function, "function");
        return () -> function.apply(getAsFloat());
    }

    /**
     * Maps this {@link FloatSupplier} to a {@link BooleanSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default BooleanSupplier mapToBoolean(Function<Float, Boolean> function) {
        requireNonNull(function, "function");
        if (function instanceof FloatToBooleanFunction) {
            return mapToBoolean((FloatToBooleanFunction) function);
        }
        return () -> function.apply(getAsFloat());
    }

    /**
     * Maps this {@link FloatSupplier} to a {@link BooleanSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default BooleanSupplier mapToBoolean(FloatToBooleanFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsBoolean(getAsFloat());
    }

    /**
     * Maps this {@link FloatSupplier} to a {@link ByteSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default ByteSupplier mapToByte(Function<Float, Byte> function) {
        requireNonNull(function, "function");
        if (function instanceof FloatToByteFunction) {
            return mapToByte((FloatToByteFunction) function);
        }
        return () -> function.apply(getAsFloat());
    }

    /**
     * Maps this {@link FloatSupplier} to a {@link ByteSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default ByteSupplier mapToByte(FloatToByteFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsByte(getAsFloat());
    }

    /**
     * Maps this {@link FloatSupplier} to a {@link CharSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default CharSupplier mapToChar(Function<Float, Character> function) {
        requireNonNull(function, "function");
        if (function instanceof FloatToCharFunction) {
            return mapToChar((FloatToCharFunction) function);
        }
        return () -> function.apply(getAsFloat());
    }

    /**
     * Maps this {@link FloatSupplier} to a {@link CharSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default CharSupplier mapToChar(FloatToCharFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsChar(getAsFloat());
    }

    /**
     * Maps this {@link FloatSupplier} to a {@link DoubleSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default DoubleSupplier mapToDouble(Function<Float, Double> function) {
        requireNonNull(function, "function");
        if (function instanceof FloatToDoubleFunction) {
            return mapToDouble((FloatToDoubleFunction) function);
        }
        return () -> function.apply(getAsFloat());
    }

    /**
     * Maps this {@link FloatSupplier} to a {@link DoubleSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default DoubleSupplier mapToDouble(FloatToDoubleFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsDouble(getAsFloat());
    }

    /**
     * Maps this {@link FloatSupplier} to a {@link FloatSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default FloatSupplier mapToFloat(Function<Float, Float> function) {
        requireNonNull(function, "function");
        if (function instanceof FloatToFloatFunction) {
            return mapToFloat((FloatToFloatFunction) function);
        }
        return () -> function.apply(getAsFloat());
    }

    /**
     * Maps this {@link FloatSupplier} to a {@link FloatSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default FloatSupplier mapToFloat(FloatToFloatFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsFloat(getAsFloat());
    }

    /**
     * Maps this {@link FloatSupplier} to a {@link IntSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default IntSupplier mapToInt(Function<Float, Integer> function) {
        requireNonNull(function, "function");
        if (function instanceof FloatToIntFunction) {
            return mapToInt((FloatToIntFunction) function);
        }
        return () -> function.apply(getAsFloat());
    }

    /**
     * Maps this {@link FloatSupplier} to a {@link IntSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default IntSupplier mapToInt(FloatToIntFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsInt(getAsFloat());
    }

    /**
     * Maps this {@link FloatSupplier} to a {@link LongSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default LongSupplier mapToLong(Function<Float, Long> function) {
        requireNonNull(function, "function");
        if (function instanceof FloatToLongFunction) {
            return mapToLong((FloatToLongFunction) function);
        }
        return () -> function.apply(getAsFloat());
    }

    /**
     * Maps this {@link FloatSupplier} to a {@link LongSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default LongSupplier mapToLong(FloatToLongFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsLong(getAsFloat());
    }

    /**
     * Maps this {@link FloatSupplier} to a {@link ShortSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default ShortSupplier mapToShort(Function<Float, Short> function) {
        requireNonNull(function, "function");
        if (function instanceof FloatToShortFunction) {
            return mapToShort((FloatToShortFunction) function);
        }
        return () -> function.apply(getAsFloat());
    }

    /**
     * Maps this {@link FloatSupplier} to a {@link ShortSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default ShortSupplier mapToShort(FloatToShortFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsShort(getAsFloat());
    }
}
