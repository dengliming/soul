/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.dromara.soul.admin.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.dromara.soul.admin.entity.SoulDictDO;
import org.dromara.soul.common.utils.DateUtils;

import java.io.Serializable;
import java.util.Optional;

/**
 * this is soul dict view to web front.
 *
 * @author dengliming
 */
@Data
@AllArgsConstructor
public class SoulDictVO implements Serializable {

    /**
     * primary key.
     */
    private String id;

    /**
     * dict type.
     */
    private String type;

    /**
     * dict code.
     */
    private String dictCode;

    /**
     * dict name.
     */
    private String dictName;

    /**
     * dict value.
     */
    private String dictValue;

    /**
     * dict desc.
     */
    private String desc;

    /**
     * sort no.
     */
    private Integer sort;

    /**
     * whether enabled.
     */
    private Boolean enabled;

    /**
     * created time.
     */
    private String dateCreated;

    /**
     * updated time.
     */
    private String dateUpdated;

    /**
     * build {@linkplain SoulDictVO}.
     *
     * @param soulDictDO {@linkplain SoulDictDO}
     * @return {@linkplain SoulDictVO}
     */
    public static SoulDictVO buildSoulDictVO(final SoulDictDO soulDictDO) {
        return Optional.ofNullable(soulDictDO)
                .map(it -> new SoulDictVO(it.getId(), it.getType(),
                        it.getDictCode(), it.getDictName(),
                        it.getDictValue(), it.getDesc(), it.getSort(), it.getEnabled(),
                        DateUtils.localDateTimeToString(it.getDateCreated().toLocalDateTime()),
                        DateUtils.localDateTimeToString(it.getDateUpdated().toLocalDateTime())))
                .orElse(null);
    }
}
