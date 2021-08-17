export const dynamicSort = <T extends object>(property: keyof T) => {
    const sortOrder = property.toString().startsWith("-") ? -1 : 1;

    return (a: T, b: T) => (
        (a[property] < b[property])
            ? -1
            : a[property] > b[property]
                ? 1
                : 0
    ) * sortOrder
}