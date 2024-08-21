N, M, B = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

# Flatten the height array
heights = [arr[i][j] for i in range(N) for j in range(M)]

# Count the occurrences of each height
height_count = [0] * 257
for h in heights:
    height_count[h] += 1

min_height = min(heights)
max_height = max(heights)

best_time = float('inf')
best_height = 0

# Pre-calculate total number of blocks
total_blocks = sum(heights)

# Iterate from min height to max height
for target_height in range(min_height, max_height + 1):
    remove_blocks = 0
    add_blocks = 0
    
    for height in range(min_height, max_height + 1):
        if height > target_height:
            remove_blocks += (height - target_height) * height_count[height]
        elif height < target_height:
            add_blocks += (target_height - height) * height_count[height]
    
    # Check if the inventory has enough blocks
    if B + remove_blocks >= add_blocks:
        time = remove_blocks * 2 + add_blocks
        if time < best_time:
            best_time = time
            best_height = target_height
        elif time == best_time and target_height > best_height:
            best_height = target_height

print(best_time, best_height)
