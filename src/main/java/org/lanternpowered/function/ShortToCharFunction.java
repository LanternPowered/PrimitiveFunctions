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
public interface ShortToCharFunction extends Function<Short, Character> {

    /**
     * Gets a casted {@link ShortToCharFunction}.
     *
     * @return The short to char function
     */
    static ShortToCharFunction cast() {
        return v -> (char) v;
    }

    /**
     * Converts the given {@link Function&lt;Short, Character&gt;} into
     * a {@link ShortToCharFunction}.
     *
     * @param function The function
     * @return The short to char function
     */
    static ShortToCharFunction of(Function<Short, Character> function) {
        requireNonNull(function, "function");
        return function instanceof ShortToCharFunction ? (ShortToCharFunction) function : function::apply;
    }

    /**
     * Applies this function to the given argument.
     *
     * @param value The value
     * @return The function result
     */
    char applyAsChar(short value);

    /**
     * Applies this function to the given argument.
     *
     * @param value The value
     * @return The function result
     */
    @Override
    default Character apply(Short value) {
        return applyAsChar(value);
    }
}
