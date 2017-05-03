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
public interface BooleanSupplier extends Supplier<Boolean>, java.util.function.BooleanSupplier {

    /**
     * Converts the given {@link Supplier&lt;Boolean&gt;} into
     * a {@link BooleanSupplier}.
     *
     * @param supplier The supplier
     * @return The boolean supplier
     */
    static BooleanSupplier of(Supplier<Boolean> supplier) {
        return supplier instanceof BooleanSupplier ? (BooleanSupplier) supplier : supplier::get;
    }

    /**
     * Converts the given {@link java.util.function.BooleanSupplier} into
     * a {@link BooleanSupplier}.
     *
     * @param supplier The supplier
     * @return The boolean supplier
     */
    static BooleanSupplier of(java.util.function.BooleanSupplier supplier) {
        return supplier instanceof BooleanSupplier ? (BooleanSupplier) supplier : supplier::getAsBoolean;
    }

    /**
     * Gets a boolean result.
     *
     * @return A result
     */
    @Override
    default Boolean get() {
        return getAsBoolean();
    }

    /**
     * Maps this {@link BooleanSupplier} to a {@link Supplier} with
     * the given result type {@link T}.
     *
     * @param function The function to map the values
     * @param <T> The result value type
     * @return The supplier
     */
    default <T> Supplier<T> map(Function<Boolean, T> function) {
        requireNonNull(function, "function");
        if (function instanceof BooleanToObjectFunction) {
            return map((BooleanToObjectFunction<T>) function);
        }
        return () -> function.apply(getAsBoolean());
    }

    /**
     * Maps this {@link BooleanSupplier} to a {@link Supplier} with
     * the given result type {@link T}.
     *
     * @param function The function to map the values
     * @param <T> The result value type
     * @return The supplier
     */
    default <T> Supplier<T> map(BooleanToObjectFunction<T> function) {
        requireNonNull(function, "function");
        return () -> function.apply(getAsBoolean());
    }

    /**
     * Maps this {@link BooleanSupplier} to a {@link BooleanSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default BooleanSupplier mapToBoolean(Function<Boolean, Boolean> function) {
        requireNonNull(function, "function");
        if (function instanceof BooleanToBooleanFunction) {
            return mapToBoolean((BooleanToBooleanFunction) function);
        }
        return () -> function.apply(getAsBoolean());
    }

    /**
     * Maps this {@link BooleanSupplier} to a {@link BooleanSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default BooleanSupplier mapToBoolean(BooleanToBooleanFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsBoolean(getAsBoolean());
    }

    /**
     * Maps this {@link BooleanSupplier} to a {@link ByteSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default ByteSupplier mapToByte(Function<Boolean, Byte> function) {
        requireNonNull(function, "function");
        if (function instanceof BooleanToByteFunction) {
            return mapToByte((BooleanToByteFunction) function);
        }
        return () -> function.apply(getAsBoolean());
    }

    /**
     * Maps this {@link BooleanSupplier} to a {@link ByteSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default ByteSupplier mapToByte(BooleanToByteFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsByte(getAsBoolean());
    }

    /**
     * Maps this {@link BooleanSupplier} to a {@link CharSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default CharSupplier mapToChar(Function<Boolean, Character> function) {
        requireNonNull(function, "function");
        if (function instanceof BooleanToCharFunction) {
            return mapToChar((BooleanToCharFunction) function);
        }
        return () -> function.apply(getAsBoolean());
    }

    /**
     * Maps this {@link BooleanSupplier} to a {@link CharSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default CharSupplier mapToChar(BooleanToCharFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsChar(getAsBoolean());
    }

    /**
     * Maps this {@link BooleanSupplier} to a {@link DoubleSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default DoubleSupplier mapToDouble(Function<Boolean, Double> function) {
        requireNonNull(function, "function");
        if (function instanceof BooleanToDoubleFunction) {
            return mapToDouble((BooleanToDoubleFunction) function);
        }
        return () -> function.apply(getAsBoolean());
    }

    /**
     * Maps this {@link BooleanSupplier} to a {@link DoubleSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default DoubleSupplier mapToDouble(BooleanToDoubleFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsDouble(getAsBoolean());
    }

    /**
     * Maps this {@link BooleanSupplier} to a {@link FloatSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default FloatSupplier mapToFloat(Function<Boolean, Float> function) {
        requireNonNull(function, "function");
        if (function instanceof BooleanToFloatFunction) {
            return mapToFloat((BooleanToFloatFunction) function);
        }
        return () -> function.apply(getAsBoolean());
    }

    /**
     * Maps this {@link BooleanSupplier} to a {@link FloatSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default FloatSupplier mapToFloat(BooleanToFloatFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsFloat(getAsBoolean());
    }

    /**
     * Maps this {@link BooleanSupplier} to a {@link IntSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default IntSupplier mapToInt(Function<Boolean, Integer> function) {
        requireNonNull(function, "function");
        if (function instanceof BooleanToIntFunction) {
            return mapToInt((BooleanToIntFunction) function);
        }
        return () -> function.apply(getAsBoolean());
    }

    /**
     * Maps this {@link BooleanSupplier} to a {@link IntSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default IntSupplier mapToInt(BooleanToIntFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsInt(getAsBoolean());
    }

    /**
     * Maps this {@link BooleanSupplier} to a {@link LongSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default LongSupplier mapToLong(Function<Boolean, Long> function) {
        requireNonNull(function, "function");
        if (function instanceof BooleanToLongFunction) {
            return mapToLong((BooleanToLongFunction) function);
        }
        return () -> function.apply(getAsBoolean());
    }

    /**
     * Maps this {@link BooleanSupplier} to a {@link LongSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default LongSupplier mapToLong(BooleanToLongFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsLong(getAsBoolean());
    }

    /**
     * Maps this {@link BooleanSupplier} to a {@link ShortSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default ShortSupplier mapToShort(Function<Boolean, Short> function) {
        requireNonNull(function, "function");
        if (function instanceof BooleanToShortFunction) {
            return mapToShort((BooleanToShortFunction) function);
        }
        return () -> function.apply(getAsBoolean());
    }

    /**
     * Maps this {@link BooleanSupplier} to a {@link ShortSupplier}.
     *
     * @param function The function to map the values
     * @return The supplier
     */
    default ShortSupplier mapToShort(BooleanToShortFunction function) {
        requireNonNull(function, "function");
        return () -> function.applyAsShort(getAsBoolean());
    }
}
