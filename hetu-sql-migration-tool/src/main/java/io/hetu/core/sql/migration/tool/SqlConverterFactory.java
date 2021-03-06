/*
 * Copyright (C) 2018-2020. Huawei Technologies Co., Ltd. All rights reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.hetu.core.sql.migration.tool;

import io.hetu.core.sql.migration.SqlMigrationException;

import static java.lang.String.format;

public class SqlConverterFactory
{
    private SqlConverterFactory() {}

    public static SqlSyntaxConverter getSqlConverter(ConvertionOptions convertionOptions) throws SqlMigrationException
    {
        switch (convertionOptions.getSourceType()) {
            case HIVE:
                return HiveSqlConverter.getHiveSqlConverter(convertionOptions);
            case IMPALA:
                return ImpalaSqlConverter.getImpalaSqlConverter(convertionOptions);
            default:
                throw new SqlMigrationException(format("Migration tool doesn't support type: %s", convertionOptions.getSourceType()));
        }
    }
}
