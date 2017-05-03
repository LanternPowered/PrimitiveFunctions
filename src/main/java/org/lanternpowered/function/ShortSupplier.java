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
public interface ShortSupplier extends Supplier<Short> {

    /**
     * Converts the given {@link Supplier&lt;Short&gt;} into
     * a {@link ShortSupplier}.
     *
     * @param supplier The supplier
     * @return The short supplier
     */
    static ShortSupplier of(Supplier<Short> supplier) {
        return supplier instanceof ShortSupplier ? (ShortSupplier) supplier : supplier::get;
    }

    /**
     * Gets a short result.
     *
     * @return A result
     */
    short getAsShort();

    /**
     * Gets a short result.
     *
     * @return A result
     */
    @Override
    default Short get() {
        return getAsShort();
    }

    /**
     * Converts this {@link ShortSupplier} into a {@link ByteSupplier}
     * that casts the short to a byte value.
     *
     * @return The byte supplier
     */
    default ByteSupplier toByte() {
        return () -> (byte) getAsShort();
    }

    /**
     * Converts this {@link ShortSupplier} into a {@link CharSupplier}
     * that casts the short to a char value.
     *
     * @return The char supplier
     */
    default CharSupplier toChar() {
        return () -> (char) getAsShort();
    }

    /**
     * Converts this {@link ShortSupplier} into a {@link DoubleSupplier}
     * that casts the short to a double value.
     *
     * @return The double supplier
     */
    default DoubleSupplier toDouble() {
        return () -> (double) getAsShort();
    }

    /**
     * Converts this {@link ShortSupplier} into a {@link FloatSupplier}
     * that casts the short to a float value.
     *
     * @return The float supplier
     */
    default FloatSupplier toFloat() {
        return () -> (float) getAsShort();
    }

    /**
     * Converts this {@link ShortSupplier} into a {@link IntSupplier}
     * that casts the short to a int value.
     *
     * @return The int supplier
     */
    default IntSupplier toInt() {
        return () -> (int) getAsShort();
    }

    /**
     * Converts this {@link ShortSupplier} into a {@link LongSupplier}
     * that casts the short to a long value.
     *
     * @return The short supplier
     */
    default LongSupplier toLong() {
        return () -> (long) getAsShort();
    }

    /**
     * Maps this {@link ShortSupplier} to a {@link Supplier} with
     * the given result type {@link T}.
     *
     * @param function The function to map the values
     * @param <T> The result value type
     * @return The supplier
     */
    default <T> Supplier<T> map(Function<Short, T> function) {
        requireNonNull(function, "function");
        if (function instanceof ShortToObjectFunction) {
            return map((ShortToObjectFunction<T>) function);
        }
        return () -> function.apply(getAsShort());
    }

    /**
     * Maps this {@link ShortSupplier} to a {@link Supplier} with
     * the given result type {@link T}.
     *
     * @param function The function to map the values
     * @param <T> The result value type
     * @return The supplier
     */
    default <T> Supplier<T> map(ShortToObjectFunction<T> function) {
        requireNonNull(function, "function");
        return () -> function.apply(getAsShort());
    }

    /**
     * Maps this {@link ShortSupplier} to a {@link BooleanSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default BooleanSupplier mapToBoolean(Function<Short, Boolean> function) {
        requireNonNull(function, "function");
        if (function instanceof ShortToBooleanFunction) {
            return mapToBoolean((ShortToBooleanFunction) function);
        }
        return () -> function.apply(getAsShort());
    }

    /**
     * Maps this {@link ShortSupplier} to a {@link BooleanSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default BooleanSupplier mapToBoolean(ShortToBooleanFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsBoolean(getAsShort());
    }

    /**
     * Maps this {@link ShortSupplier} to a {@link ByteSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default ByteSupplier mapToByte(Function<Short, Byte> function) {
        requireNonNull(function, "function");
        if (function instanceof ShortToByteFunction) {
            return mapToByte((ShortToByteFunction) function);
        }
        return () -> function.apply(getAsShort());
    }

    /**
     * Maps this {@link ShortSupplier} to a {@link ByteSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default ByteSupplier mapToByte(ShortToByteFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsByte(getAsShort());
    }

    /**
     * Maps this {@link ShortSupplier} to a {@link CharSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default CharSupplier mapToChar(Function<Short, Character> function) {
        requireNonNull(function, "function");
        if (function instanceof ShortToCharFunction) {
            return mapToChar((ShortToCharFunction) function);
        }
        return () -> function.apply(getAsShort());
    }

    /**
     * Maps this {@link ShortSupplier} to a {@link CharSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default CharSupplier mapToChar(ShortToCharFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsChar(getAsShort());
    }

    /**
     * Maps this {@link ShortSupplier} to a {@link LongSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default DoubleSupplier mapToDouble(Function<Short, Double> function) {
        requireNonNull(function, "function");
        if (function instanceof ShortToDoubleFunction) {
            return mapToDouble((ShortToDoubleFunction) function);
        }
        return () -> function.apply(getAsShort());
    }

    /**
     * Maps this {@link ShortSupplier} to a {@link LongSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default DoubleSupplier mapToDouble(ShortToDoubleFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsDouble(getAsShort());
    }

    /**
     * Maps this {@link ShortSupplier} to a {@link FloatSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default FloatSupplier mapToFloat(Function<Short, Float> function) {
        requireNonNull(function, "function");
        if (function instanceof ShortToFloatFunction) {
            return mapToFloat((ShortToFloatFunction) function);
        }
        return () -> function.apply(getAsShort());
    }

    /**
     * Maps this {@link ShortSupplier} to a {@link FloatSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default FloatSupplier mapToFloat(ShortToFloatFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsFloat(getAsShort());
    }

    /**
     * Maps this {@link ShortSupplier} to a {@link LongSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default IntSupplier mapToInt(Function<Short, Integer> function) {
        requireNonNull(function, "function");
        if (function instanceof ShortToIntFunction) {
            return mapToInt((ShortToIntFunction) function);
        }
        return () -> function.apply(getAsShort());
    }

    /**
     * Maps this {@link ShortSupplier} to a {@link IntSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default IntSupplier mapToInt(ShortToIntFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsInt(getAsShort());
    }

    /**
     * Maps this {@link ShortSupplier} to a {@link LongSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default LongSupplier mapToLong(Function<Short, Long> function) {
        requireNonNull(function, "function");
        if (function instanceof ShortToLongFunction) {
            return mapToLong((ShortToLongFunction) function);
        }
        return () -> function.apply(getAsShort());
    }

    /**
     * Maps this {@link ShortSupplier} to a {@link LongSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default LongSupplier mapToLong(ShortToLongFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsLong(getAsShort());
    }

    /**
     * Maps this {@link ShortSupplier} to a {@link ShortSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default ShortSupplier mapToShort(Function<Short, Short> function) {
        requireNonNull(function, "function");
        if (function instanceof ShortToShortFunction) {
            return mapToShort((ShortToShortFunction) function);
        }
        return () -> function.apply(getAsShort());
    }

    /**
     * Maps this {@link ShortSupplier} to a {@link ShortSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default ShortSupplier mapToShort(ShortToShortFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsShort(getAsShort());
    }
}
