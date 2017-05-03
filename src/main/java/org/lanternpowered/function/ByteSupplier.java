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
public interface ByteSupplier extends Supplier<Byte> {

    /**
     * Converts the given {@link Supplier&lt;Byte&gt;} into
     * a {@link ByteSupplier}.
     *
     * @param supplier The supplier
     * @return The byte supplier
     */
    static ByteSupplier of(Supplier<Byte> supplier) {
        requireNonNull(supplier, "supplier");
        return supplier instanceof ByteSupplier ? (ByteSupplier) supplier : supplier::get;
    }

    /**
     * Gets a byte result.
     *
     * @return A result
     */
    byte getAsByte();

    /**
     * Gets a byte result.
     *
     * @return A result
     */
    @Override
    default Byte get() {
        return getAsByte();
    }

    /**
     * Converts this {@link ByteSupplier} into a {@link CharSupplier}
     * that casts the byte to a char value.
     *
     * @return The char supplier
     */
    default CharSupplier toChar() {
        return () -> (char) getAsByte();
    }

    /**
     * Converts this {@link ByteSupplier} into a {@link DoubleSupplier}
     * that casts the byte to a double value.
     *
     * @return The double supplier
     */
    default DoubleSupplier toDouble() {
        return () -> (double) getAsByte();
    }

    /**
     * Converts this {@link ByteSupplier} into a {@link FloatSupplier}
     * that casts the byte to a float value.
     *
     * @return The float supplier
     */
    default FloatSupplier toFloat() {
        return () -> (float) getAsByte();
    }

    /**
     * Converts this {@link ByteSupplier} into a {@link IntSupplier}
     * that casts the byte to a int value.
     *
     * @return The int supplier
     */
    default IntSupplier toInt() {
        return () -> (int) getAsByte();
    }

    /**
     * Converts this {@link ByteSupplier} into a {@link LongSupplier}
     * that casts the byte to a long value.
     *
     * @return The long supplier
     */
    default LongSupplier toLong() {
        return () -> (long) getAsByte();
    }

    /**
     * Converts this {@link ByteSupplier} into a {@link ShortSupplier}
     * that casts the byte to a short value.
     *
     * @return The short supplier
     */
    default ShortSupplier toShort() {
        return () -> (short) getAsByte();
    }

    /**
     * Maps this {@link ByteSupplier} to a {@link Supplier} with
     * the given result type {@link T}.
     *
     * @param function The function to map the values
     * @param <T> The result value type
     * @return The supplier
     */
    default <T> Supplier<T> map(Function<Byte, T> function) {
        requireNonNull(function, "function");
        if (function instanceof ByteToObjectFunction) {
            return map((ByteToObjectFunction<T>) function);
        }
        return () -> function.apply(getAsByte());
    }

    /**
     * Maps this {@link ByteSupplier} to a {@link Supplier} with
     * the given result type {@link T}.
     *
     * @param function The function to map the values
     * @param <T> The result value type
     * @return The supplier
     */
    default <T> Supplier<T> map(ByteToObjectFunction<T> function) {
        requireNonNull(function, "function");
        return () -> function.apply(getAsByte());
    }

    /**
     * Maps this {@link ByteSupplier} to a {@link BooleanSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default BooleanSupplier mapToBoolean(Function<Byte, Boolean> function) {
        requireNonNull(function, "function");
        if (function instanceof ByteToBooleanFunction) {
            return mapToBoolean((ByteToBooleanFunction) function);
        }
        return () -> function.apply(getAsByte());
    }

    /**
     * Maps this {@link ByteSupplier} to a {@link BooleanSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default BooleanSupplier mapToBoolean(ByteToBooleanFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsBoolean(getAsByte());
    }

    /**
     * Maps this {@link ByteSupplier} to a {@link ByteSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default ByteSupplier mapToByte(Function<Byte, Byte> function) {
        requireNonNull(function, "function");
        if (function instanceof ByteToByteFunction) {
            return mapToByte((ByteToByteFunction) function);
        }
        return () -> function.apply(getAsByte());
    }

    /**
     * Maps this {@link ByteSupplier} to a {@link ByteSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default ByteSupplier mapToByte(ByteToByteFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsByte(getAsByte());
    }

    /**
     * Maps this {@link ByteSupplier} to a {@link CharSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default CharSupplier mapToChar(Function<Byte, Character> function) {
        requireNonNull(function, "function");
        if (function instanceof ByteToCharFunction) {
            return mapToChar((ByteToCharFunction) function);
        }
        return () -> function.apply(getAsByte());
    }

    /**
     * Maps this {@link ByteSupplier} to a {@link CharSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default CharSupplier mapToChar(ByteToCharFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsChar(getAsByte());
    }

    /**
     * Maps this {@link ByteSupplier} to a {@link DoubleSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default DoubleSupplier mapToDouble(Function<Byte, Double> function) {
        requireNonNull(function, "function");
        if (function instanceof ByteToDoubleFunction) {
            return mapToDouble((ByteToDoubleFunction) function);
        }
        return () -> function.apply(getAsByte());
    }

    /**
     * Maps this {@link ByteSupplier} to a {@link DoubleSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default DoubleSupplier mapToDouble(ByteToDoubleFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsDouble(getAsByte());
    }

    /**
     * Maps this {@link ByteSupplier} to a {@link FloatSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default FloatSupplier mapToFloat(Function<Byte, Float> function) {
        requireNonNull(function, "function");
        if (function instanceof ByteToFloatFunction) {
            return mapToFloat((ByteToFloatFunction) function);
        }
        return () -> function.apply(getAsByte());
    }

    /**
     * Maps this {@link ByteSupplier} to a {@link FloatSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default FloatSupplier mapToFloat(ByteToFloatFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsFloat(getAsByte());
    }

    /**
     * Maps this {@link ByteSupplier} to a {@link IntSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default IntSupplier mapToInt(Function<Byte, Integer> function) {
        requireNonNull(function, "function");
        if (function instanceof ByteToIntFunction) {
            return mapToInt((ByteToIntFunction) function);
        }
        return () -> function.apply(getAsByte());
    }

    /**
     * Maps this {@link ByteSupplier} to a {@link IntSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default IntSupplier mapToInt(ByteToIntFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsInt(getAsByte());
    }

    /**
     * Maps this {@link ByteSupplier} to a {@link LongSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default LongSupplier mapToLong(Function<Byte, Long> function) {
        requireNonNull(function, "function");
        if (function instanceof ByteToLongFunction) {
            return mapToLong((ByteToLongFunction) function);
        }
        return () -> function.apply(getAsByte());
    }

    /**
     * Maps this {@link ByteSupplier} to a {@link LongSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default LongSupplier mapToLong(ByteToLongFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsLong(getAsByte());
    }

    /**
     * Maps this {@link ByteSupplier} to a {@link ShortSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default ShortSupplier mapToShort(Function<Byte, Short> function) {
        requireNonNull(function, "function");
        if (function instanceof ByteToShortFunction) {
            return mapToShort((ByteToShortFunction) function);
        }
        return () -> function.apply(getAsByte());
    }

    /**
     * Maps this {@link ByteSupplier} to a {@link ShortSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default ShortSupplier mapToShort(ByteToShortFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsShort(getAsByte());
    }
}
