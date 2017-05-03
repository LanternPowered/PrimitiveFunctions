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

@FunctionalInterface
public interface BooleanToBooleanFunction extends Function<Boolean, Boolean> {

    /**
     * Gets a {@link BooleanToBooleanFunction} that inverts the value.
     *
     * @return The function
     */
    static BooleanToBooleanFunction invert() {
        return value -> !value;
    }

    /**
     * Gets a identity {@link BooleanToBooleanFunction}.
     *
     * @return The function
     */
    static BooleanToBooleanFunction identity() {
        return value -> value;
    }

    /**
     * Converts the given {@link Function&lt;Boolean, Boolean&gt;} into
     * a {@link BooleanToBooleanFunction}.
     *
     * @param function The function
     * @return The boolean to boolean function
     */
    static BooleanToBooleanFunction of(Function<Boolean, Boolean> function) {
        requireNonNull(function, "function");
        return function instanceof BooleanToBooleanFunction ? (BooleanToBooleanFunction) function : function::apply;
    }

    /**
     * Applies this function to the given argument.
     *
     * @param value The value
     * @return The function result
     */
    boolean applyAsBoolean(boolean value);

    /**
     * Applies this function to the given argument.
     *
     * @param value The value
     * @return The function result
     */
    @Override
    default Boolean apply(Boolean value) {
        return applyAsBoolean(value);
    }
}
