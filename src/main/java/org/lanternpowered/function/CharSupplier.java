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
public interface CharSupplier extends Supplier<Character> {

    /**
     * Converts the given {@link Supplier&lt;Character&gt;} into
     * a {@link CharSupplier}.
     *
     * @param supplier The supplier
     * @return The char supplier
     */
    static CharSupplier of(Supplier<Character> supplier) {
        requireNonNull(supplier, "supplier");
        return supplier instanceof CharSupplier ? (CharSupplier) supplier : supplier::get;
    }

    /**
     * Gets a char result.
     *
     * @return A result
     */
    char getAsChar();

    /**
     * Gets a char result.
     *
     * @return A result
     */
    @Override
    default Character get() {
        return getAsChar();
    }

    /**
     * Converts this {@link CharSupplier} into a {@link ByteSupplier}
     * that casts the char to a byte value.
     *
     * @return The byte supplier
     */
    default ByteSupplier toByte() {
        return () -> (byte) getAsChar();
    }

    /**
     * Converts this {@link CharSupplier} into a {@link DoubleSupplier}
     * that casts the char to a double value.
     *
     * @return The double supplier
     */
    default DoubleSupplier toDouble() {
        return () -> (double) getAsChar();
    }

    /**
     * Converts this {@link CharSupplier} into a {@link FloatSupplier}
     * that casts the char to a float value.
     *
     * @return The float supplier
     */
    default FloatSupplier toFloat() {
        return () -> (float) getAsChar();
    }

    /**
     * Converts this {@link CharSupplier} into a {@link IntSupplier}
     * that casts the char to a int value.
     *
     * @return The int supplier
     */
    default IntSupplier toInt() {
        return () -> (int) getAsChar();
    }

    /**
     * Converts this {@link CharSupplier} into a {@link LongSupplier}
     * that casts the char to a long value.
     *
     * @return The long supplier
     */
    default LongSupplier toLong() {
        return () -> (long) getAsChar();
    }

    /**
     * Converts this {@link CharSupplier} into a {@link ShortSupplier}
     * that casts the char to a short value.
     *
     * @return The short supplier
     */
    default ShortSupplier toShort() {
        return () -> (short) getAsChar();
    }

    /**
     * Maps this {@link CharSupplier} to a {@link Supplier} with
     * the given result type {@link T}.
     *
     * @param function The function to map the values
     * @param <T> The result value type
     * @return The supplier
     */
    default <T> Supplier<T> map(Function<Character, T> function) {
        requireNonNull(function, "function");
        if (function instanceof CharToObjectFunction) {
            return map((CharToObjectFunction<T>) function);
        }
        return () -> function.apply(getAsChar());
    }

    /**
     * Maps this {@link CharSupplier} to a {@link Supplier} with
     * the given result type {@link T}.
     *
     * @param function The function to map the values
     * @param <T> The result value type
     * @return The supplier
     */
    default <T> Supplier<T> map(CharToObjectFunction<T> function) {
        requireNonNull(function, "function");
        return () -> function.apply(getAsChar());
    }

    /**
     * Maps this {@link CharSupplier} to a {@link BooleanSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default BooleanSupplier mapToBoolean(Function<Character, Boolean> function) {
        requireNonNull(function, "function");
        if (function instanceof CharToBooleanFunction) {
            return mapToBoolean((CharToBooleanFunction) function);
        }
        return () -> function.apply(getAsChar());
    }

    /**
     * Maps this {@link CharSupplier} to a {@link BooleanSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default BooleanSupplier mapToBoolean(CharToBooleanFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsBoolean(getAsChar());
    }

    /**
     * Maps this {@link CharSupplier} to a {@link ByteSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default ByteSupplier mapToByte(Function<Character, Byte> function) {
        requireNonNull(function, "function");
        if (function instanceof CharToByteFunction) {
            return mapToByte((CharToByteFunction) function);
        }
        return () -> function.apply(getAsChar());
    }

    /**
     * Maps this {@link CharSupplier} to a {@link ByteSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default ByteSupplier mapToByte(CharToByteFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsByte(getAsChar());
    }

    /**
     * Maps this {@link CharSupplier} to a {@link CharSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default CharSupplier mapToChar(Function<Character, Character> function) {
        requireNonNull(function, "function");
        if (function instanceof CharToCharFunction) {
            return mapToChar((CharToCharFunction) function);
        }
        return () -> function.apply(getAsChar());
    }

    /**
     * Maps this {@link CharSupplier} to a {@link CharSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default CharSupplier mapToChar(CharToCharFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsChar(getAsChar());
    }

    /**
     * Maps this {@link CharSupplier} to a {@link DoubleSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default DoubleSupplier mapToDouble(Function<Character, Double> function) {
        requireNonNull(function, "function");
        if (function instanceof CharToDoubleFunction) {
            return mapToDouble((CharToDoubleFunction) function);
        }
        return () -> function.apply(getAsChar());
    }

    /**
     * Maps this {@link CharSupplier} to a {@link DoubleSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default DoubleSupplier mapToDouble(CharToDoubleFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsDouble(getAsChar());
    }

    /**
     * Maps this {@link CharSupplier} to a {@link FloatSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default FloatSupplier mapToFloat(Function<Character, Float> function) {
        requireNonNull(function, "function");
        if (function instanceof CharToFloatFunction) {
            return mapToFloat((CharToFloatFunction) function);
        }
        return () -> function.apply(getAsChar());
    }

    /**
     * Maps this {@link CharSupplier} to a {@link FloatSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default FloatSupplier mapToFloat(CharToFloatFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsFloat(getAsChar());
    }

    /**
     * Maps this {@link CharSupplier} to a {@link IntSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default IntSupplier mapToInt(Function<Character, Integer> function) {
        requireNonNull(function, "function");
        if (function instanceof CharToIntFunction) {
            return mapToInt((CharToIntFunction) function);
        }
        return () -> function.apply(getAsChar());
    }

    /**
     * Maps this {@link CharSupplier} to a {@link IntSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default IntSupplier mapToInt(CharToIntFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsInt(getAsChar());
    }

    /**
     * Maps this {@link CharSupplier} to a {@link LongSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default LongSupplier mapToLong(Function<Character, Long> function) {
        requireNonNull(function, "function");
        if (function instanceof CharToLongFunction) {
            return mapToLong((CharToLongFunction) function);
        }
        return () -> function.apply(getAsChar());
    }

    /**
     * Maps this {@link CharSupplier} to a {@link LongSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default LongSupplier mapToLong(CharToLongFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsLong(getAsChar());
    }

    /**
     * Maps this {@link CharSupplier} to a {@link ShortSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default ShortSupplier mapToShort(Function<Character, Short> function) {
        requireNonNull(function, "function");
        if (function instanceof CharToShortFunction) {
            return mapToShort((CharToShortFunction) function);
        }
        return () -> function.apply(getAsChar());
    }

    /**
     * Maps this {@link CharSupplier} to a {@link ShortSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default ShortSupplier mapToShort(CharToShortFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsShort(getAsChar());
    }
}
